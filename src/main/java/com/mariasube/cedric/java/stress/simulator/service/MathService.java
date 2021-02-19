package com.mariasube.cedric.java.stress.simulator.service;

public class MathService implements StressService {

    private static final int MAX_FIBONACCI_RANK = 50;

    public long calculateRandomFibonacci() {
        long rank = (long) (MAX_FIBONACCI_RANK * Math.random());

        return calculateFibonacci(rank);
    }

    public long calculateFibonacci(long rank) {
        if (rank == 0) {
            return 0;
        } else if (rank == 1) {
            return 1;
        } else {
            return this.calculateFibonacci(rank - 1) + this.calculateFibonacci(rank - 2);
        }
    }
}
