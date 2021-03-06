package triangle;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Triangle {

    double[] sides;

    public Triangle(double a, double b, double c) {
        sides = new double[]{a, b, c};
    }

    public Triangle(double[] s) {
        sides = new double[s.length];
        System.arraycopy(s, 0, sides, 0, s.length);
    }

    public Triangle(Point a, Point b, Point c) {
        sides = new double[3];
        sides[0] = Math.sqrt(getPow(b.x, a.x) + getPow(b.y, a.y));
        sides[1] = Math.sqrt(getPow(b.x, c.x) + getPow(b.y, c.y));
        sides[2] = Math.sqrt(getPow(c.x, a.x) + getPow(c.y, a.y));
    }

    private double getPow(int x, int x2) {
        return Math.pow((double) (x - x2), 2.0);
    }

    private int uniqueSides() {

       return (int) Arrays.stream(sides).distinct().count();
        
       /* int distinctIntegers = 0;

        for (int j = 0; j < sides.length; j++) {
            double thisInt = sides[j];
            boolean seenThisIntBefore = false;
            for (int i = 0; i < j; i++) {
                if (thisInt == sides[i]) {
                    seenThisIntBefore = true;
                }
            }
            if (!seenThisIntBefore) {
                distinctIntegers++;
            }
        }
        return distinctIntegers;
        */
    }

    public boolean isScalene() {
        return uniqueSides() == 3;
    }

    public boolean isEquilateral() {
        return uniqueSides() == 1;
    }

    public boolean isIsosceles() {
        return uniqueSides() == 2;
    }
}