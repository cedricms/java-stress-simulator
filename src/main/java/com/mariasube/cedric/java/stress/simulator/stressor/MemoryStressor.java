package com.mariasube.cedric.java.stress.simulator.stressor;

import com.mariasube.cedric.java.stress.simulator.domain.vehicle.Vehicle;
import com.mariasube.cedric.java.stress.simulator.domain.vehicle.VehicleFactory;

import java.util.LinkedList;
import java.util.List;

public class MemoryStressor extends AbstractStressor {

    private static final int MAX_OBJECTS = 100 * 1000 * 1000;

    @Override
    public void stress() {
        List<Vehicle> vehicles = new LinkedList<>();

        for (int i = 0; i < MAX_OBJECTS; i++) {
            vehicles.add(VehicleFactory.createRandomVehicle());
        }
    }
}