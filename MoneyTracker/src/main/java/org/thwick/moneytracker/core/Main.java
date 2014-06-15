package org.thwick.moneytracker.core;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

public class Main {

	public static void main(String[] args) throws Exception
    {
        Server server = new Server(9080);
        
        final ServletHolder servletHolder = new ServletHolder( new SpringServlet() );
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "org.thwick");
        
        final ServletContextHandler restContext = new ServletContextHandler();   
        restContext.setContextPath( "/rest" );
        restContext.addServlet( servletHolder, "/api/*" );  
        restContext.addEventListener( new ContextLoaderListener() );

        restContext.setInitParameter( "contextClass", AnnotationConfigWebApplicationContext.class.getName() );
        restContext.setInitParameter( "contextConfigLocation", AppConfig.class.getName() );
        restContext.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        ContextHandler fileContext = new ContextHandler("/");
        fileContext.setContextPath("/angular");
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });
        resource_handler.setResourceBase("./angular-app");

        fileContext.setHandler(resource_handler);
        
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { restContext, fileContext });
        
        server.setHandler( contexts );
        
        server.start();
        server.join(); 
    } 
	
}
