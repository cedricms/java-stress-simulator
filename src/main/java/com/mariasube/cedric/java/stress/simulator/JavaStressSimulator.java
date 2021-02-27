package com.mariasube.cedric.java.stress.simulator;

import com.mariasube.cedric.java.stress.simulator.stressor.AbstractStressor;
import com.mariasube.cedric.java.stress.simulator.stressor.memory.MemoryStressor;
import com.mariasube.cedric.java.stress.simulator.stressor.memory.centralize.CentralizedResourceStressor;
import com.mariasube.cedric.java.stress.simulator.stressor.process.IterativeProcessStressor;
import com.mariasube.cedric.java.stress.simulator.stressor.process.RecursiveProcessStressor;
import com.mariasube.cedric.java.stress.simulator.stressor.Stressor;

import java.util.LinkedList;
import java.util.List;

public class JavaStressSimulator {

    public static void main( String[] args ) {
        List<Stressor> stressors = new LinkedList<>();

        MemoryStressor memoryStressor = new MemoryStressor();
        stressors.add(memoryStressor);

        RecursiveProcessStressor recursiveProcessStressor = new RecursiveProcessStressor();
        stressors.add(recursiveProcessStressor);

        IterativeProcessStressor iterativeProcessStressor = new IterativeProcessStressor();
        stressors.add(iterativeProcessStressor);

        CentralizedResourceStressor centralizedResourceStressor = new CentralizedResourceStressor();
        stressors.add(centralizedResourceStressor);

        for (Stressor stressor : stressors) {
            AbstractStressor abstractStressor = (AbstractStressor) stressor;
            abstractStressor.start();
        }
    }
}
