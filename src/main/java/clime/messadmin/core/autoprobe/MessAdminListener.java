/**
 * 
 */
package clime.messadmin.core.autoprobe;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import clime.messadmin.filter.MessAdminFilter;
import clime.messadmin.filter.MessAdminThreadLocal;

/**
 * @author C&eacute;drik LIME
 * @since 4.4
 */
public class MessAdminListener extends clime.messadmin.core.MessAdminListener
		implements ServletRequestListener {

	/**
	 * 
	 */
	public MessAdminListener() {
		super();
	}

	/* Resquest-related events */

	/** {@inheritDoc} */
	public void requestInitialized(ServletRequestEvent sre) {
		final ServletRequest request = sre.getServletRequest();
		if ( ! (request instanceof HttpServletRequest)) {
			// not http, don't do anything
			return;
		}
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final ServletContext servletContext = sre.getServletContext();
		MessAdminFilter.requestInitialized(httpRequest, null, servletContext);
	}

	/** {@inheritDoc} */
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletRequest request = sre.getServletRequest();
		if ( ! (request instanceof HttpServletRequest)) {
			// not http, don't do anything
			return;
		}
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final ServletContext servletContext = sre.getServletContext();
		try {
			MessAdminFilter.requestDestroyed(httpRequest, null, servletContext);
		} finally {
			MessAdminThreadLocal.remove();
		}
	}

}
