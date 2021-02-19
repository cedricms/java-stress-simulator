package com.mariasube.cedric.java.stress.simulator;

import com.mariasube.cedric.java.stress.simulator.stressor.MemoryStressor;

public class JavaStressSimulator {

    public static void main( String[] args ) {
        MemoryStressor memoryStressor = new MemoryStressor();
        memoryStressor.start();
    }
}
