package com.cases.mysqls.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:global-dev.properties")
@ConfigurationProperties("app")
public class AppPropertiesConfiguration {

    private List<Server> server = new ArrayList<Server>();

    public List<Server> getServer() {
        return server;
    }

    public void setServer(List<Server> server) {
        this.server = server;
    }

    public static class Server {
        private String ip;
        private String port;
        private String attribute1;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public String getAttribute1() {
            return attribute1;
        }

        public void setAttribute1(String attribute1) {
            this.attribute1 = attribute1;
        }
    }
}
