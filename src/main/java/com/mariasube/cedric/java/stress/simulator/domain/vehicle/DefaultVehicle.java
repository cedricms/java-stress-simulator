package com.mariasube.cedric.java.stress.simulator.domain.vehicle;

import lombok.Data;

@Data
public class DefaultVehicle implements Vehicle {

    private String type;
    private int numberOfWheels = 0;
}
