package com.mariasube.cedric.java.stress.simulator.service;

public class MathService implements StressService {

    private static final int MAX_FIBONACCI_RANK = 50;

    public long calculateRandomRecursiveFibonacci() {
        long rank = generateRandomRank();

        return calculateRecursiveFibonacci(rank);
    }

    public long calculateRecursiveFibonacci(long rank) {
        if (rank == 0) {
            return 0;
        } else if (rank == 1) {
            return 1;
        } else {
            return this.calculateRecursiveFibonacci(rank - 1) + this.calculateRecursiveFibonacci(rank - 2);
        }
    }

    public long calculateRandomIterativeFibonacci() {
        long rank = generateRandomRank();

        return calculateIterativeFibonacci(rank);
    }

    public long calculateIterativeFibonacci(long rank) {
        if (rank == 0) {
            return 0;
        } else if (rank == 1) {
            return 1;
        } else if (rank == 2) {
            return 1;
        } else {
            long a = 1;
            long b = 1;
            long result = 0;

            for (long i = 3; i <= rank; i++) {
                result = a + b;
                a = b;
                b = result;
            }

            return result;
        }
    }

    private long generateRandomRank() {
        return (long) (MAX_FIBONACCI_RANK * Math.random());
    }
}
