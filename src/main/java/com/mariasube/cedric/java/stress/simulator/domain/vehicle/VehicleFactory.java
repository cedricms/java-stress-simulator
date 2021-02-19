package com.mariasube.cedric.java.stress.simulator.domain.vehicle;

public class VehicleFactory {

    private static final int NUMBER_OF_VEHICLE_TYPES = 3;

    public static Vehicle createRandomVehicle() {
        int vehicleType = (int) (NUMBER_OF_VEHICLE_TYPES * Math.random());
        switch (vehicleType) {
            case 0:
                return new Bike();
            case 1:
                return new Trike();
            default:
                return new Car();
        }
    }
}
