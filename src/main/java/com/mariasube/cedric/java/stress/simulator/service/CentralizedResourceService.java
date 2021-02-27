package com.mariasube.cedric.java.stress.simulator.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mariasube.cedric.java.stress.simulator.domain.vehicle.DefaultVehicle;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CentralizedResourceService implements StressService {

    public static final int WAIT_TIME_IN_MILLISECONDS = 3 * 1000;

    public synchronized static List<DefaultVehicle> loadVehicles() throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        List<DefaultVehicle> vehicles = mapper.readValue(new File("./src/main/resources/data/CentralizedResourceData.json"), new TypeReference<List<DefaultVehicle>>(){});

        simulateProcessTime((long) (WAIT_TIME_IN_MILLISECONDS * Math.random()));

        return vehicles;
    }

    private static void simulateProcessTime(long millisecondsToProcess) {
        long start = System.currentTimeMillis();

        while (millisecondsToProcess > (System.currentTimeMillis() - start)) {
            doSomething();
        }
    }

    private static double doSomething() {
        return Math.random() * Math.random();
    }
}
