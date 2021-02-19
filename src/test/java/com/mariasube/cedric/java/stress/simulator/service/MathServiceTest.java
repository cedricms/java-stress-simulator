package com.mariasube.cedric.java.stress.simulator.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MathServiceTest {

    @Test
    public void calculateFibonacciWhenRankZeroThenZero() {
        // Given
        MathService mathService = new MathService();
        long rank = 0;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void calculateFibonacciWhenRankOneThenOne() {
        // Given
        MathService mathService = new MathService();
        long rank = 1;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void calculateFibonacciWhenRankTwoThenOne() {
        // Given
        MathService mathService = new MathService();
        long rank = 2;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void calculateFibonacciWhenRankThreeThenTwo() {
        // Given
        MathService mathService = new MathService();
        long rank = 3;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void calculateFibonacciWhenRankFourThenThree() {
        // Given
        MathService mathService = new MathService();
        long rank = 4;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculateFibonacciWhenRankFiveThenFive() {
        // Given
        MathService mathService = new MathService();
        long rank = 5;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void calculateFibonacciWhenRankSixThenEight() {
        // Given
        MathService mathService = new MathService();
        long rank = 6;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void calculateFibonacciWhenRankSevenThenThirteen() {
        // Given
        MathService mathService = new MathService();
        long rank = 7;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void calculateFibonacciWhenRankEightThenTwentyOne() {
        // Given
        MathService mathService = new MathService();
        long rank = 8;

        // When
        long result = mathService.calculateFibonacci(rank);

        // Then
        assertThat(result).isEqualTo(21);
    }
}
