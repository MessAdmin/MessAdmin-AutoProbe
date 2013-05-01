This MessAdmin plugin enables automatic probe registration. No more adding MessAdmin Listener in web.xml!

Requires a Servlet 2.4 compliant container, such as Tomcat 5.

To install, simply drop MessAdmin-AutoProbe2.jar next next to MessAdmin.jar or in WEB-INF/lib/.

Note that you will lose some functionalities, except when running a Servlet 3.0-compliant container:
* message sending
* outgoing network bandwidth usage (HTTP response length)
* uncaught errors reporting
* HTTP response status codes (200, 404, 500, etc.)
To enable those functionalities, either add the MessAdmin Filter in web.xml (yes, I know:
what's the point of automatic registration if you need to add configuration? Such is life...),
or update to a Servlet 3.0-compliant container (e.g. Tomcat 7).

In any case, you will still need to declare the administration servlet (if not monitoring the whole server).


Servlet 3 notes
===============
For the Servlet 3 part of this plugin to work, you /must/ have a 3.0-level web.xml artefact:
	<web-app version="3.0"
Also, your web.xml must /not/ specify  metadata-complete="true", as this prevents automatic component registration.
