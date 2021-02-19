package com.mariasube.cedric.java.stress.simulator.domain.vehicle;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public abstract class WheeledVehicle implements Vehicle {

    private int numberOfWheels = 0;

    public WheeledVehicle(int numberOfWheels) {
        super();

        this.numberOfWheels = numberOfWheels;

        log.debug("Vehicle : " + this.getClass().getSimpleName());
    }
}
