public class SumExcludingExtremes {
    public static int sum(int[] numbers) {
    if (numbers == null || numbers.length <= 1) {
      return 0;
    }

    int min = Arrays.stream(numbers).min().getAsInt();
    int max = Arrays.stream(numbers).max().getAsInt();

    int sum = 0;
    for (int n : numbers) {
      sum += n;
    }

    return sum - min - max;
  }
}
