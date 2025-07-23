package be.calculator;

import be.calculator.application.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryOperationTest {

    private static Calculator calculator;

    @BeforeAll
    public static void before() {
        calculator = new Calculator();
    }
    
    private static Stream<Arguments> provideArithmeticOperations() {
        return Stream.of(
                Arguments.of("3+5", 8.0),
                Arguments.of("3-5", -2.0),
                Arguments.of("3*5", 15.0),
                Arguments.of("3(5)", 15.0),
                Arguments.of("3/5", 0.6),
                Arguments.of("3/0", Double.POSITIVE_INFINITY),
                Arguments.of("-3/0", Double.NEGATIVE_INFINITY)
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideArithmeticOperations")
     void testArithmeticOperations(String input, double expected) {
        double output = calculator.compute(input);
        assertEquals(expected, output, 0.0001, 
            String.format("Test failed for input: %s", input));
    }

    @Test
     void testSquareRoot() {
        String input = "sqrt(4)";
        double output = calculator.compute(input);
        assertEquals(2.0, output, 0.0001);
    }

}
