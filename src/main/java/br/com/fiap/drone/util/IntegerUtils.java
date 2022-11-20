package br.com.fiap.drone.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public final class IntegerUtils {

    public static int geneteRandNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt(max-min) + min;
    }
}
