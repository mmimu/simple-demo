package com.mimu.simple.spring.jetty;

import com.mimu.simple.spring.jetty.config.ApplicationConfig;
import com.mimu.simple.spring.jetty.server.SimpleJettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author: mimu
 * date: 2019/7/15
 */
public class AppSimpleJettyServer extends SimpleJettyServer {
    private static final Logger logger = LoggerFactory.getLogger(AppSimpleJettyServer.class);

    private AppSimpleJettyServer(int port, Class<?> clazz) {
        super(port, clazz);
    }

    public static void main(String args[]) {
        try {
            logger.info("system params initial complete.");
            int port = 9090;
            new AppSimpleJettyServer(port, ApplicationConfig.class).run();
        } catch (Exception e) {
            logger.error("start server error", e);
        }
    }
}
