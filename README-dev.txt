For automatic Servlet 3 component registration, you /must/ have a 3.0-level web.xml artefact:
	<web-app version="3.0"
Also, your web.xml must /not/ specify  metadata-complete="true", as this prevents automatic component registration.


Given the very specific requirements for Servlet 3 automatic registration to work at all,
this plugin will only register the MessAdmin ServletFilter, and is thus to be used in complement
to the MessAdmin Listener declared via the TLD mechanism.
The rational behind this decision is that, in the real world, very few web applications
will meet the aforementioned requirements. It is therefore better to run in a "lite"
mode than none at all.


Implementation notes
====================
The Servlet 3.0 specification offers different ways to register artefacts (in this order):
* via a META-INF/web-fragment.xml file
* via annotations
* via a javax.servlet.ServletContainerInitializer class
This implementation uses the web-fragment.xml route, since it can easily be included in a
pre-Servlet 3.0 jar (it won't be used in that case).
