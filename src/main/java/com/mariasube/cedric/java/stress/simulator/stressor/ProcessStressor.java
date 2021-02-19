package com.mariasube.cedric.java.stress.simulator.stressor;

import com.mariasube.cedric.java.stress.simulator.service.MathService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProcessStressor extends AbstractStressor {

    private static final int MAX_OBJECTS = 10 * 1000 * 1000;

    @Override
    public void stress() {
        for (int i = 0; i < MAX_OBJECTS; i++) {
            MathService mathService = new MathService();
            long result = mathService.calculateRandomFibonacci();

            log.debug("MathService Fibonacci : " + result);
        }
    }
}
