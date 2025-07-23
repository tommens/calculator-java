package be.calculator;

import be.calculator.parser.ShuntingYard;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShuntingYardTest {

    private static Stream<Arguments> provideRPNTestCases() {
        return Stream.of(
            Arguments.of("3(5)", "3 5 *"),
            Arguments.of("(2+3)(4+1)", "2 3 + 4 1 + *"),
            Arguments.of("6 + (3+1)(2+2)", "6 3 1 + 2 2 + * +"),
            Arguments.of("2 + 4 * 10 ^ 2 / 16 - 3", "2 4 10 2 ^ * 16 / + 3 -"),
            Arguments.of("(2 + 1) * (8 / 2) / (18 * 2)", "2 1 + 8 2 / * 18 2 * /"),
            Arguments.of("(2 + (4 - 3)) * (10 / 5)", "2 4 3 - + 10 5 / *"),
            Arguments.of(
                "((15 * 2^3 - (48 / 6 + 2^2)) * 3) / ((100 / 25 * 3) + (7^2 - 40))",
                "15 2 3 ^ * 48 6 / 2 2 ^ + - 3 * 100 25 / 3 * 7 2 ^ 40 - + /"
            ),
            Arguments.of(
                "(((3 + 5) * (2 - 1)) + ((6 / 2) ^ 2)) * (4 + 1)",
                "3 5 + 2 1 - * 6 2 / 2 ^ + 4 1 + *"
            ),
            Arguments.of(
                "(((((1 + 2) * 3) + 4) * (5 + (6 - 2))) ^ 2)",
                "1 2 + 3 * 4 + 5 6 2 - + * 2 ^"
            ),
            Arguments.of(
                "((2^3^2) + ((4 + 1) * (6 - 2))) / ((7 + 3) * (2 + 2))",
                "2 3 2 ^ ^ 4 1 + 6 2 - * + 7 3 + 2 2 + * /"
            ),
            Arguments.of(
                "((((1 + 2) + 3) + 4) + 5) * (((6 * 7) * 8) * 9)",
                "1 2 + 3 + 4 + 5 + 6 7 * 8 * 9 * *"
            ),
            Arguments.of(
                "(((((10 - 2)^2) + ((3 + 1)^3)) * ((8 / 4)^2)))",
                "10 2 - 2 ^ 3 1 + 3 ^ + 8 4 / 2 ^ *"
            ),
            Arguments.of(
                "(((((1+2)*(3+4))-((5+6)*(7+8)))+((9+10)*(11+12)))^2)",
                "1 2 + 3 4 + * 5 6 + 7 8 + * - 9 10 + 11 12 + * + 2 ^"
            )
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideRPNTestCases")
    void testInfixToRPN(String input, String expectedOutput) {
        String actualOutput = convertListToString(ShuntingYard.infixToRPN(input));
        assertEquals(expectedOutput, actualOutput, 
            String.format("Test failed for input: %s", input));
    }
    
    private String convertListToString(final List<Object> input) {
        return input.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

}
