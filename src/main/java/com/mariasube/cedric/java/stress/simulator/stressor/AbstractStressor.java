package com.mariasube.cedric.java.stress.simulator.stressor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractStressor extends Thread implements Stressor {

    public void run(){
        log.debug("Start stressor : " + this.getClass().getSimpleName());
        this.stress();
        log.debug("End stressor : " + this.getClass().getSimpleName());
    }
}
