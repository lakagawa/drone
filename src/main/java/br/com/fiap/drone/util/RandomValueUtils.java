package br.com.fiap.drone.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public final class RandomValueUtils {

    public static int generateRandNumber(int min, int max) {
        return new Random().nextInt(max-min) + min;
    }

    public static double generateRandNumber(double min, double max) {
        return new Random().nextDouble(max-min) + min;
    }

}
