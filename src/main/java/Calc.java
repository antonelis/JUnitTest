public class Calc {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
    return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero exception");
        }
        return a / b;
    }
    private int arraySize(int[] numbers) {
        return numbers.length;
    }

    public int calcArraySize(int[] numbers) {
        return arraySize(numbers);
    }

}
