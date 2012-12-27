package fr.byob.gae.server.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.inject.Singleton;
import com.sun.jersey.core.util.Base64;

import fr.byob.gae.server.commons.guice.InjectLogger;

@Singleton
public class AuthenticationFilter implements Filter {

	@InjectLogger
	private Logger log;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	private final static String USR = "rest-user";
	private final static String PWD = "niancat";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;

		// OPTIONS methods is used for CORS, no auth is required with this
		// method
		if (!"OPTIONS".equals(httpRequest.getMethod())) {
			final String authHeader = httpRequest.getHeader("authorization");
			if (authHeader == null) {
				log.warn("Login failed : no auth header!");
				httpResponse.setContentType("text/html");
				httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN,
						"Unauthorized access, no authorization header.");
				return;
			}

			final String encodedValue = authHeader.split(" ")[1];
			final String[] decodedValue = Base64.base64Decode(encodedValue)
					.split(":");

			if (decodedValue.length != 2) {
				log.warn("Login failed : malformed auth header!");
				httpResponse.setContentType("text/html");
				httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN,
						"Unauthorized access, malformed authorization header.");
				return;
			}

			final String login = decodedValue[0];
			final String password = decodedValue[1];

			if (!USR.equals(login)) {
				log.info("Login failed for " + login);
				httpResponse.setContentType("text/html");
				httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN,
						"Unauthorized access, unknown user.");
				return;
			}

			if (!PWD.equals(password)) {
				log.info("Login failed for " + login);
				httpResponse.setContentType("text/html");
				httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN,
						"Unauthorized access, wrong password.");
				return;
			}

			log.info("Login success for " + login);
		}
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}
}
