package com.mariasube.cedric.java.stress.simulator.stressor.memory.centralize;

import com.mariasube.cedric.java.stress.simulator.domain.vehicle.DefaultVehicle;
import com.mariasube.cedric.java.stress.simulator.service.CentralizedResourceService;
import com.mariasube.cedric.java.stress.simulator.stressor.AbstractStressor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class CarCentralizedResourceStressor extends AbstractStressor {

    private static final int MAX_STRESSES = 10 * 1000 * 1000;

    @Override
    public void stress() {
        for (int i = 0; i < MAX_STRESSES; i++) {
            try {
                List<DefaultVehicle> vehicles = CentralizedResourceService.loadVehicles();

                long numberOfCars = getNumberOfCars(vehicles);
            } catch (IOException ioe) {
                log.error("Unable to read the vehicle JSON", ioe);
            } catch (InterruptedException ie) {
                log.error("Problem during the wait", ie);
            }
        }
    }

    public long getNumberOfCars(List<DefaultVehicle> vehicles) {
        return vehicles.stream().filter(vehicle -> "Car".equals(vehicle.getType())).count();
    }
}
