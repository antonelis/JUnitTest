package triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private final Triangle scaleneTriangle = new Triangle(3.0, 4.0, 5.0);
    private final Triangle equilateralTriangle = new Triangle(5.0, 5.0, 5.0);
    private final Triangle isoscelesTriangle = new Triangle(2.0, 2.0, 4.0);

    @Test
    void isScalene() {
        boolean scalene = scaleneTriangle.isScalene();
        assertTrue(scalene);
    }

    @Test
    void isoscelesTriangle() {
        boolean scalene = isoscelesTriangle.isIsosceles();
        assertTrue(scalene);
    }

    @Test
    void isEquilateral() {
        boolean scalene = equilateralTriangle.isEquilateral();
        assertTrue(scalene);
    }
    @Test
    void notEquilateral() {
        boolean scalene = equilateralTriangle.isScalene();
        assertFalse(scalene);
    }
    @Test
    void notIsoscelesTriangle() {
        boolean scalene = isoscelesTriangle.isEquilateral();
        assertFalse(scalene);
    }
    @Test
    void notScalene() {
        boolean scalene = scaleneTriangle.isIsosceles();
        assertFalse(scalene);
    }
}