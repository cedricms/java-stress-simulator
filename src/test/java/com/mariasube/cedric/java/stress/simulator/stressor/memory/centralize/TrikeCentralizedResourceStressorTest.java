package com.mariasube.cedric.java.stress.simulator.stressor.memory.centralize;

import com.mariasube.cedric.java.stress.simulator.domain.vehicle.DefaultVehicle;
import com.mariasube.cedric.java.stress.simulator.service.CentralizedResourceService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrikeCentralizedResourceStressorTest {

    @Test
    public void getNumberOfTrikesGivenListWithNoTrikeThen0() throws IOException {
        // Given
        TrikeCentralizedResourceStressor trikeCentralizedResourceStressor = new TrikeCentralizedResourceStressor();
        List<DefaultVehicle> vehicles = new LinkedList<>();

        // When
        long numberOfTrikes = trikeCentralizedResourceStressor.getNumberOfTrikes(vehicles);

        // Then
        assertThat(numberOfTrikes).isEqualTo(0);
    }

    @Test
    public void getNumberOfTrikesGivenListWith3TrikesThen3() throws IOException, InterruptedException {
        // Given
        TrikeCentralizedResourceStressor trikeCentralizedResourceStressor = new TrikeCentralizedResourceStressor();
        List<DefaultVehicle> vehicles = CentralizedResourceService.loadVehicles();

        // When
        long numberOfTrikes = trikeCentralizedResourceStressor.getNumberOfTrikes(vehicles);

        // Then
        assertThat(numberOfTrikes).isEqualTo(3);
    }
}
