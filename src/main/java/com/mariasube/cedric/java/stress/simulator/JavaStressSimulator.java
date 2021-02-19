package com.mariasube.cedric.java.stress.simulator;

import com.mariasube.cedric.java.stress.simulator.stressor.AbstractStressor;
import com.mariasube.cedric.java.stress.simulator.stressor.MemoryStressor;
import com.mariasube.cedric.java.stress.simulator.stressor.ProcessStressor;
import com.mariasube.cedric.java.stress.simulator.stressor.Stressor;

import java.util.LinkedList;
import java.util.List;

public class JavaStressSimulator {

    public static void main( String[] args ) {
        List<Stressor> stressors = new LinkedList<>();

        MemoryStressor memoryStressor = new MemoryStressor();
        stressors.add(memoryStressor);

        ProcessStressor processStressor = new ProcessStressor();
        stressors.add(processStressor);

        for (Stressor stressor : stressors) {
            AbstractStressor abstractStressor = (AbstractStressor) stressor;
            abstractStressor.start();
        }
    }
}
