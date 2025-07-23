package be.calculator;

import be.calculator.application.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeClass
    public static void before() {
        calculator = new Calculator();
    }

    @Test
    public void testImplicitMultiplication1() {
        String input = "3(5)";
        double output = calculator.compute(input);
        Assert.assertEquals(15.0, output, 0);
    }

    @Test
    public void testImplicitMultiplication2() {
        String input = "(2+3)(4+1)";
        double output = calculator.compute(input);
        Assert.assertEquals(25.0, output, 0);
    }

    @Test
    public void testImplicitMultiplication3() {
        String input = "6 + (3+1)(2+2)";
        double output = calculator.compute(input);
        Assert.assertEquals(22.0, output, 0);
    }

    @Test
    public void test1() {
        String input = "2 + 4 * 10 ^ 2 / 16 - 3";
        double ouput = calculator.compute(input);
        Assert.assertEquals(24.0, ouput, 3);
    }

    @Test
    public void test2() {
        String input = "(2 + 1) * (8 / 2) / (18 * 2)";
        double ouput = calculator.compute(input);
        Assert.assertEquals(0.333, ouput, 3);
    }

    @Test
    public void test3() {
        String input = "(2 + (4 - 3)) * (10 / 5)";
        double ouput = calculator.compute(input);
        Assert.assertEquals(6.0, ouput, 3);
    }

    @Test
    public void test4() {
        String input = "((15 * 2^3 - (48 / 6 + 2^2)) * 3) / ((100 / 25 * 3) + (7^2 - 40))";
        double ouput = calculator.compute(input);
        Assert.assertEquals(15.428, ouput, 3);
    }

    @Test
    public void test5() {
        String input = "(((3 + 5) * (2 - 1)) + ((6 / 2) ^ 2)) * (4 + 1)";
        double ouput = calculator.compute(input);
        Assert.assertEquals(85, ouput, 0);
    }

    @Test
    public void test6() {
        String input = "(((((1 + 2) * 3) + 4) * (5 + (6 - 2))) ^ 2)";
        double ouput = calculator.compute(input);
        Assert.assertEquals(13689, ouput, 0);
    }

    @Test
    public void test7() {
        String input = "((2^3^2) + ((4 + 1) * (6 - 2))) / ((7 + 3) * (2 + 2))";
        double ouput = calculator.compute(input);
        Assert.assertEquals(13.3, ouput, 3);
    }

    @Test
    public void test8() {
        String input = "((((1 + 2) + 3) + 4) + 5) * (((6 * 7) * 8) * 9)";
        double ouput = calculator.compute(input);
        Assert.assertEquals(45360, ouput, 0);
    }

    @Test
    public void test9() {
        String input = "(((((10 - 2)^2) + ((3 + 1)^3)) * ((8 / 4)^2)))";
        double ouput = calculator.compute(input);
        Assert.assertEquals(512, ouput, 0);
    }

    @Test
    public void test10() {
        String input = "(((((1+2)*(3+4))-((5+6)*(7+8)))+((9+10)*(11+12)))^2)";
        double ouput = calculator.compute(input);
        Assert.assertEquals(85849, ouput, 0);
    }

}
