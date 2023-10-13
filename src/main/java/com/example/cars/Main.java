package com.example.cars;

import java.util.Arrays;

public class Main {
    public static long carParkingRoof(long[] cars, int k) {
        Arrays.sort(cars);  // Sort the parking spots in ascending order

        int n = cars.length;
        long minRoofLength = Long.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            long roofLength = cars[i + k - 1] - cars[i] + 1;
            minRoofLength = Math.min(minRoofLength, roofLength);
        }

        return minRoofLength;
    }

    public static void main(String[] args) {
        long[] parkingSpots = {1, 2, 4, 6, 9};
        int k = 3;

        long minRoofLength = carParkingRoof(parkingSpots, k);
        System.out.println("Minimum roof length: " + minRoofLength);
    }
}
