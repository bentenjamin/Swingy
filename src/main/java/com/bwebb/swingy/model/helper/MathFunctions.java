package com.bwebb.swingy.model.helper;

import java.util.Random;

public abstract class MathFunctions {
    public static int rand_gaus(int min, int max, double skew) {
        /*
        credit to https://stackoverflow.com/users/4975772/joshuakcockrell
        https://stackoverflow.com/questions/25582882/javascript-math-random-normal-distribution-gaussian-bell-curve/36481059#36481059
         */
        Random random = new Random();

        double num = random.nextGaussian();

        num = num / 10.0 + 0.5; // Translate to 0 -> 1
        if (num > 1 || num < 0) {
            num = rand_gaus(min, max, skew);
        } // resample between 0 and 1 if out of range
        num = Math.pow(num, skew); // Skew
        num *= max - min; // Stretch to fill range
        num += min; // offset to min
        return (int) num;
    }

    //generic skew to mean of ~35
    public static int rand_gaus(int min, int max) {
        return rand_gaus(min, max, 1.7);
    }
}
