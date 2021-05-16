package com.atguigu.springcloud.server;

import com.atguigu.springcloud.controller.IndexServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class TomcatServer {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8088);
        connector.setURIEncoding("UTF-8");
        tomcat.getService().addConnector(connector);

        IndexServlet indexServlet = new IndexServlet();
        //http://127.0.0.1/project/xxxx
        Context context = tomcat.addContext("project", null);
        tomcat.addServlet(context,"servlet",indexServlet);
        context.addServletMappingDecoded("/index.do","servlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
