package com.mariasube.cedric.java.stress.simulator.service;

import com.mariasube.cedric.java.stress.simulator.domain.vehicle.DefaultVehicle;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CentralizedResourceServiceTest {

    @Test
    public void loadVehiclesThenNineVehicles() throws IOException, InterruptedException {
        // Given

        // When
        List<DefaultVehicle> vehicles = CentralizedResourceService.loadVehicles();

        // Then
        assertThat(vehicles.size()).isEqualTo(9);
    }
}
