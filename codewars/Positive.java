public class Positive {
    public static int sum(int[] arr) {
        if (arr == null)
            return 0;
        return java.util.Arrays.stream(arr).filter(num -> num > 0).sum();
    }
}