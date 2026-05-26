public class SumArray {
    public static double sum(double[] numbers) {
        if (numbers.length != 0) return Arrays.stream(numbers).sum();
        else return 0;
    }
}