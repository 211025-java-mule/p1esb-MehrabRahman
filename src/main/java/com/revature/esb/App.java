package com.revature.esb;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@RestController
public class App {
    public static void main(String[] args) throws LifecycleException {
        Tomcat server = new Tomcat();
        server.setPort(8081);
        server.getConnector();
        server.addContext("", null);

        AnnotationConfigWebApplicationContext springmvc = new AnnotationConfigWebApplicationContext();
        springmvc.register(App.class);
        server.addServlet("", "dispatcher", new DispatcherServlet(springmvc)).addMapping("/");
        server.start();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!\n";
    }

    @GetMapping("/flow1")
    public String flow1() {
        //Call p1a car service via HTTP client

        //Append date purchased to p1a response

        //Save to local file

        //Return response to user

        return null;
    }
}
