package be.calculator;

import be.calculator.application.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void before() {
        calculator = new Calculator();
    }
    
    private static Stream<Arguments> provideArithmeticOperations() {
        return Stream.of(
            Arguments.of("2 + 4 * 10 ^ 2 / 16 - 3", 24.0, 0.001),
            Arguments.of("(2 + 1) * (8 / 2) / (18 * 2)", 0.333, 0.001),
            Arguments.of("(2 + (4 - 3)) * (10 / 5)", 6.0, 0.001),
            Arguments.of("((15 * 2^3 - (48 / 6 + 2^2)) * 3) / ((100 / 25 * 3) + (7^2 - 40))", 15.428, 0.001),
            Arguments.of("(((3 + 5) * (2 - 1)) + ((6 / 2) ^ 2)) * (4 + 1)", 85.0, 0.0),
            Arguments.of("(((((1 + 2) * 3) + 4) * (5 + (6 - 2))) ^ 2)", 13689.0, 0.0),
            Arguments.of("((2^3^2) + ((4 + 1) * (6 - 2))) / ((7 + 3) * (2 + 2))", 13.3, 0.1),
            Arguments.of("((((1 + 2) + 3) + 4) + 5) * (((6 * 7) * 8) * 9)", 45360.0, 0.0),
            Arguments.of("(((((10 - 2)^2) + ((3 + 1)^3)) * ((8 / 4)^2)))", 512.0, 0.0),
            Arguments.of("(((((1+2)*(3+4))-((5+6)*(7+8)))+((9+10)*(11+12)))^2)", 
            85849.0, 0.0)
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideArithmeticOperations")
    void testArithmeticOperations(String input, double expected, double delta) {
        double output = calculator.compute(input);
        assertEquals(expected, output, delta, 
            String.format("Test failed for input: %s", input));
    }

    private static Stream<Arguments> provideImplicitMultiplicationOperations() {
        return Stream.of(
            Arguments.of("3(5)", 15.0, 0.0),
            Arguments.of("(2+3)(4+1)", 25.0, 0.0),
            Arguments.of("6 + (3+1)(2+2)", 22.0, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideImplicitMultiplicationOperations")
    void testImplicitMultiplicationOperations(String input, double expected, double delta) {
        double output = calculator.compute(input);
        assertEquals(expected, output, delta);
    }

}
