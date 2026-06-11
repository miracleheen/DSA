public class SpinWords {
  public String spinWords(String sentence) {
   StringBuilder result = new StringBuilder();

    String[] words = sentence.split(" ");

    for (int i = 0; i < words.length; i++) {
      String word = words[i];

      if (word.length() >= 5) {
        result.append(new StringBuilder(word).reverse());
      } else {
        result.append(word);
      }

      if (i < words.length - 1) {
        result.append(" ");
      }
    }

    return result.toString();
  }
}