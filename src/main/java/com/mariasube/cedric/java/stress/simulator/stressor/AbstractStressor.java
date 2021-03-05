package com.mariasube.cedric.java.stress.simulator.stressor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractStressor extends Thread implements Stressor {

    private static final String PACKAGE_PREFIX = "com.mariasube.cedric.";

    public AbstractStressor() {
        super();

        this.setName(getFormattedThreadName());
    }

    private String getFormattedThreadName() {
        String canonicalClassName = this.getClass().getCanonicalName();

        if (canonicalClassName.contains(PACKAGE_PREFIX)) {
            return canonicalClassName.substring(PACKAGE_PREFIX.length());
        } else {
            return canonicalClassName;
        }
    }

    public void run(){
        log.debug("Start stressor : " + this.getClass().getSimpleName());
        this.stress();
        log.debug("End stressor : " + this.getClass().getSimpleName());
    }
}
