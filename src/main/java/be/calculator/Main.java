package be.calculator;

import be.calculator.application.Calculator;

public class Main {

    public static void compute(Calculator c, String arg) {
        System.out.print("The expression ");
        System.out.println(arg);
        System.out.print(" evaluates to ");
        System.out.println(c.compute(arg));
    }

    public static void main(String[] args) {
        System.out.println("Start running the application");
        Calculator c = new Calculator();
        if (args.length != 0) {
            for (String arg : args) {
                compute(c,arg);
             }
        } else {
            compute(c, "5 * (3 + (2 * (7 - 4)^2 - 1)) / (9 - 2^2)");
            // should compute 20
        }

    }
}