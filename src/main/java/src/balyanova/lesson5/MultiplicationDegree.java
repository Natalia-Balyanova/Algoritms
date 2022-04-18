package src.balyanova.lesson5;

import java.text.DecimalFormat;

public class MultiplicationDegree {
    public static void main(String[] args) {
        System.out.println(degreeRecursion(2, -3));
    }

    private static float degreeRecursion(int number, int degreeNum) {
        if(degreeNum == 1) {
            return number;
        }
        if(degreeNum == 0 && number != 0) {
            return 1;
        }
        if(degreeNum < 0) {
            return 1 / (number * degreeRecursion(number, Math.abs(-degreeNum) - 1));
        }
        return number * degreeRecursion(number, degreeNum - 1);
    }
    //округление хромое
    private static double degreeRecursion(double number, double degreeNum) {
        if(degreeNum == 1) {
            return number;
        }
        if(degreeNum == 0 && number != 0) {
            return 1;
        }
        if(degreeNum < 0) {
            return 1 / (number * degreeRecursion(number, Math.abs(-degreeNum) - 1));
        }
        return number * degreeRecursion(number, degreeNum - 1);
    }
}
