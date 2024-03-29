package fr.byob.gae.server.rest.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * An Empty, "do nothing servlet" to add to the context. Otherwise, the filters
 * will never kick in.
 */
public class EmptyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException,
			IOException {
		throw new IllegalStateException("unable to service request");
	}
}