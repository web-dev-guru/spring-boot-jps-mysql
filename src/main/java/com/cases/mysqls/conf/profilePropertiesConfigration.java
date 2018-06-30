package com.cases.mysqls.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class profilePropertiesConfigration {
    private RunTimeObj runtimeobj;


    public RunTimeObj getRuntimeobj() {
        return runtimeobj;
    }

    public void setRuntimeobj(RunTimeObj runtimeobj) {
        this.runtimeobj = runtimeobj;
    }

    public static class RunTimeObj{
        private String attribute1;

        public String getAttribute1() {
            return attribute1;
        }

        public void setAttribute1(String attribute1) {
            this.attribute1 = attribute1;
        }

        public String getAttribute2() {
            return attribute2;
        }

        public void setAttribute2(String attribute2) {
            this.attribute2 = attribute2;
        }

        private String attribute2;

    }
}
