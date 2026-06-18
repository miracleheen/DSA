public class HighestScoringWord {
     public static String high(String s) {
        String[] words = s.split(" ");
        String bestWord = "";
        int bestScore = -1;

        for (String word : words) {
            int score = 0;

            for (int i = 0; i < word.length(); i++) {
                score += word.charAt(i) - 'a' + 1;
            }

            if (score > bestScore) {
                bestScore = score;
                bestWord = word;
            }
        }

        return bestWord;
    }
}
