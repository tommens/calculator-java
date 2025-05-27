package be.guho;

import be.guho.application.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        if (args.length != 0) {
            for (String arg : args) {
                System.out.println(calculator.compute(arg));
            }
        } else {
            System.out.println(calculator.compute("5 * (3 + (2 * (7 - 4)^2 - 1)) / (9 - 2^2)")); // 20
        }
    }
}