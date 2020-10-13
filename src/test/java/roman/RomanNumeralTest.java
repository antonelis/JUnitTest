package roman;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    public RomanNumeral romanNumeral;

    @BeforeEach
    void init() {
        romanNumeral = new RomanNumeral();
    }

    @AfterEach
    void cleanup() {
        romanNumeral = null;
    }

    @ParameterizedTest
    @CsvSource({"I,1", "V,5", "X,10","L,50","C,100","D,500","M,1000"})
    void singleNumber(String character, Integer integers) {
        assertEquals(integers, romanNumeral.convert(character));
    }

    @Test
    void numberWithEmptyString(){
        assertEquals(0,romanNumeral.convert(""));
    }

    @Test
    void numberWithManyDigits() {
        assertEquals(12, romanNumeral.convert("XII"));
    }

    @Test
    void numberWithSubtractiveNotation() {
        assertEquals(4, romanNumeral.convert("IV"));
    }

    @Test
    void checksIfFiftyFiveInRomanNumeralIsEqualsFiftyFive() {
        assertEquals(55, romanNumeral.convert("LV"));
    }

    @Test
    void numberWithAndWithoutSubtractiveNotation() {
        assertEquals(154, romanNumeral.convert("CLIV"));
    }

    @Test
    @Disabled
    void numberWithInvalidCharactersInString(){
        assertThrows(IllegalArgumentException.class, () -> romanNumeral.convert("XBA"));
    }
}