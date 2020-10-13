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

    @Test
    void constructorWithPointArgumentsCreatesTriangleWithSidesOfRightLength() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 4);
        Point p3 = new Point(5, 1);
        double[] sides = {3.0, 5.0, 4.0};

        Triangle triangle = new Triangle(p1, p2, p3);
        assertArrayEquals(sides, triangle.sides);
    }

    @Test
    void constructorWithLengthArray() {
        double[] sides = {3.0, 5.0, 4.0};

        Triangle triangle = new Triangle(sides);
        assertArrayEquals(sides, triangle.sides);
    }
}