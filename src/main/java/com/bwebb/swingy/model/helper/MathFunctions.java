package com.bwebb.swingy.model.helper;

import java.util.Random;
import static java.lang.Math;

import static com.bwebb.swingy.model.helper.MathFunctions.randn_bm;

public abstract class MathFunctions {
    public static int randn_bm(int min, int max, int skew) {
        /*
        credit to https://stackoverflow.com/users/4975772/joshuakcockrell
        https://stackoverflow.com/questions/25582882/javascript-math-random-normal-distribution-gaussian-bell-curve/36481059#36481059
         */
        Random random = new Random();

        double u = 0, v = 0;
        while (u == 0) {
            u = random.nextDouble();
        } //Converting [0,1) to (0,1)
        while(v == 0) {
            v = random.nextDouble();
        }
        double num = Math.sqrt( -2.0 * Math.log( u ) ) * Math.cos( 2.0 * Math.PI * v );

        num = num / 10.0 + 0.5; // Translate to 0 -> 1
        if (num > 1 || num < 0) {
            num = randn_bm(min, max, skew);
        } // resample between 0 and 1 if out of range
        num = Math.pow(num, skew); // Skew
        num *= max - min; // Stretch to fill range
        num += min; // offset to min
        return (int) num;
    }
}
