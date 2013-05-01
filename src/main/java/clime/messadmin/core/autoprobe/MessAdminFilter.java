/**
 *
 */
package clime.messadmin.core.autoprobe;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;

/**
 * @author C&eacute;drik LIME
 * @since 4.4
 */
/*@WebFilter(description="MessAdmin Filter (Servlet 3)",
		displayName="MessAdmin Filter",
		filterName=MessAdminFilter.NAME,
		urlPatterns={MessAdminFilter.URL_PATTERN})*/
public class MessAdminFilter extends clime.messadmin.filter.MessAdminFilter {
	static final String NAME = "MessAdminFilter";//$NON-NLS-1$
	static final String URL_PATTERN = "/*";//$NON-NLS-1$

	/**
	 *
	 */
	public MessAdminFilter() {
		super();
	}

	/** {@inheritDoc} */
//	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		/* MessAdminLister-AutoProbe implements javax.servlet.ServletRequestListener:
		 * this MessAdmin Filter does not need to manage the requests lifecycle.
		 */
		super.shouldManageRequestsLifecycle = false;
	}
}
