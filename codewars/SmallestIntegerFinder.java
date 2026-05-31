public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        return IntStream.of(args).min().getAsInt();
    }
}