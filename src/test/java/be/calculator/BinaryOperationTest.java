package be.calculator;

import be.calculator.application.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryOperationTest {

    private static Calculator calculator;

    @BeforeClass
    public static void before() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        String input = "3+5";
        double output = calculator.compute(input);
        Assert.assertEquals(8.0, output, 0);
    }

    @Test
    public void testSubtraction() {
        String input = "3-5";
        double output = calculator.compute(input);
        Assert.assertEquals(-2.0, output, 0);
    }

    @Test
    public void testMultiplication() {
        String input = "3*5";
        double output = calculator.compute(input);
        Assert.assertEquals(15.0, output, 0);
    }

    @Test
    public void testImplicitMultiplication() {
        String input = "3(5)";
        double output = calculator.compute(input);
        Assert.assertEquals(15.0, output, 0);
    }

    @Test
    public void testDivision() {
        String input = "3/5";
        double output = calculator.compute(input);
        Assert.assertEquals(0.6, output, 0);
    }

    @Test
    public void testPositiveDivisionByZero() {
        // division by zero of a positive number should give positive infinity
        String input = "3/0";
        double output = calculator.compute(input);
        Assert.assertEquals(Double.POSITIVE_INFINITY, output, 0);
    }

    @Test
    public void testNegativeDivisionByZero() {
        // division by zero of a positive number should give negative infinity
        String input = "-3/0";
        double output = calculator.compute(input);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, output, 0);
    }

    @Test
    public void testSquareRoot() {
        // division by zero of a positive number should give positive infinity
        String input = "sqrt(4)";
        double output = calculator.compute(input);
        Assert.assertEquals(2.0, output, 0);
    }

}
