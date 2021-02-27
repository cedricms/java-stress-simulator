package com.mariasube.cedric.java.stress.simulator.stressor.memory.centralize;

import com.mariasube.cedric.java.stress.simulator.stressor.AbstractStressor;

public class CentralizedResourceStressor extends AbstractStressor {

    @Override
    public void stress() {
        BikeCentralizedResourceStressor bikeCentralizedResourceStressor = new BikeCentralizedResourceStressor();
        bikeCentralizedResourceStressor.start();

        CarCentralizedResourceStressor carCentralizedResourceStressor = new CarCentralizedResourceStressor();
        carCentralizedResourceStressor.start();

        TrikeCentralizedResourceStressor trikeCentralizedResourceStressor = new TrikeCentralizedResourceStressor();
        trikeCentralizedResourceStressor.start();
    }
}
