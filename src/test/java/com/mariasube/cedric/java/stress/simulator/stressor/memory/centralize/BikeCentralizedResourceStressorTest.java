package com.mariasube.cedric.java.stress.simulator.stressor.memory.centralize;

import com.mariasube.cedric.java.stress.simulator.domain.vehicle.DefaultVehicle;
import com.mariasube.cedric.java.stress.simulator.service.CentralizedResourceService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BikeCentralizedResourceStressorTest {

    @Test
    public void getNumberOfBikesGivenListWithNoBikeThen0() throws IOException {
        // Given
        BikeCentralizedResourceStressor bikeCentralizedResourceStressor = new BikeCentralizedResourceStressor();
        List<DefaultVehicle> vehicles = new LinkedList<>();

        // When
        long numberOfBikes = bikeCentralizedResourceStressor.getNumberOfBikes(vehicles);

        // Then
        assertThat(numberOfBikes).isEqualTo(0);
    }

    @Test
    public void getNumberOfBikesGivenListWith4BikesThen4() throws IOException, InterruptedException {
        // Given
        BikeCentralizedResourceStressor bikeCentralizedResourceStressor = new BikeCentralizedResourceStressor();
        List<DefaultVehicle> vehicles = CentralizedResourceService.loadVehicles();

        // When
        long numberOfBikes = bikeCentralizedResourceStressor.getNumberOfBikes(vehicles);

        // Then
        assertThat(numberOfBikes).isEqualTo(4);
    }
}
