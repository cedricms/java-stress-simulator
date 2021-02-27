package com.mariasube.cedric.java.stress.simulator.stressor.memory.centralize;

import com.mariasube.cedric.java.stress.simulator.domain.vehicle.DefaultVehicle;
import com.mariasube.cedric.java.stress.simulator.service.CentralizedResourceService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCentralizedResourceStressorTest {

    @Test
    public void getNumberOfCarsGivenListWithNoCarThen0() throws IOException {
        // Given
        CarCentralizedResourceStressor carCentralizedResourceStressor = new CarCentralizedResourceStressor();
        List<DefaultVehicle> vehicles = new LinkedList<>();

        // When
        long numberOfCars = carCentralizedResourceStressor.getNumberOfCars(vehicles);

        // Then
        assertThat(numberOfCars).isEqualTo(0);
    }

    @Test
    public void getNumberOfCarsGivenListWith2CarsThen2() throws IOException, InterruptedException {
        // Given
        CarCentralizedResourceStressor carCentralizedResourceStressor = new CarCentralizedResourceStressor();
        List<DefaultVehicle> vehicles = CentralizedResourceService.loadVehicles();

        // When
        long numberOfCars = carCentralizedResourceStressor.getNumberOfCars(vehicles);

        // Then
        assertThat(numberOfCars).isEqualTo(2);
    }
}
