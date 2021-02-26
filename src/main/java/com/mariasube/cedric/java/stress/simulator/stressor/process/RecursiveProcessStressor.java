package com.mariasube.cedric.java.stress.simulator.stressor.process;

import com.mariasube.cedric.java.stress.simulator.service.MathService;
import com.mariasube.cedric.java.stress.simulator.stressor.AbstractStressor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecursiveProcessStressor extends AbstractStressor {

    private static final int MAX_OBJECTS = 10 * 1000 * 1000;

    @Override
    public void stress() {
        for (int i = 0; i < MAX_OBJECTS; i++) {
            MathService mathService = new MathService();
            long result = mathService.calculateRandomRecursiveFibonacci();

            log.debug("MathService recursive Fibonacci : " + result);
        }
    }
}
