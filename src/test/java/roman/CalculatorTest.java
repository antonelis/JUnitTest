package roman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import roman.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @AfterEach
    void cleanup() {
        calculator = null;
    }

    @Test
    @Order(1)
    @Tag("Math")
    @DisplayName("Testing Add Method With Positive Numbers")
    void testPositiveAdd() {
        int expected = 2;
        int actual = calculator.add(1, 1);
        assertEquals(expected, actual, "should add two positive numbers");
    }

    @Test
    @Order(2)
    @Tag("Math")
    @DisplayName("Testing Add Method With Negative Numbers")
    void testNegativeAdd() {
        int expected = -2;
        int actual = calculator.add(-1, -1);
        assertEquals(expected, actual, "should add two negative numbers");
    }

    @Test
    @Order(3)
    @Tag("Math")
    @DisplayName("Testing Divide Method")
    void testDivideWithZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Divide with zero should throw an exception");
    }

    @Test
    @Order(4)
    @Tag("Math")
    @DisplayName("Testing Divide Method")
    void testDivide() {
        assertEquals(2, calculator.divide(4, 2), "should divide two positive numbers");
    }

    @Nested
    @Tag("Math")
    @DisplayName("Testing Subtraction Method")
    class Subtraction {

        @Test
        @DisplayName("When Subtracting With Positive Numbers")
        void testPositiveSubtraction() {
            assertEquals(2, calculator.subtraction(4, 2), "should subtract two positive numbers");
        }

        @Test
        @DisplayName("When Subtracting With Negative Number")
        void testNegativeSubtraction() {
            assertEquals(-5, calculator.subtraction(-3, 2), "should subtract one negative number");
        }

        @Test
        @DisplayName("When Subtracting With Two Negative Numbers")
        void testTwoNegativeSubtraction() {
            assertEquals(-1, calculator.subtraction(-3, -2), "should subtract two negative numbers");
        }

    }

    @Test
    @Order(5)
    @Tag("Math")
    @DisplayName("Testing Multiply Method")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, calculator.multiply(2, 2), "should multiply two positive numbers"),
                () -> assertEquals(0, calculator.multiply(5, 0), "should multiply with zero"),
                () -> assertEquals(-2, calculator.multiply(-2, 1), "should multiply with negative number"),
                () -> assertEquals(10, calculator.multiply(-2, -5), "should multiply with two negative numbers")
        );
    }

    @Test
    @Order(6)
    @DisplayName("Testing Arrays Size")
    void testArraysSize(TestInfo testInfo) {
        int[] numArray = {2, 4, 6, 8, 10};
        assertEquals(5, calculator.calcArraySize(numArray), "should calc arrays length");
        assertDoesNotThrow(
                () -> calculator.calcArraySize(numArray)
        );
        System.out.println(testInfo.getDisplayName());
    }

    @Order(7)
    @ParameterizedTest
    @ValueSource(ints = {23, 43, 15, -43, 75, Integer.MAX_VALUE})
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(calculator.isOdd(number));
    }

}