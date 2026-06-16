public class FirstUniqueCharacterFinder {
     public static String firstNonRepeatingLetter(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); ) {
            int cp = s.codePointAt(i);
            int lowerCp = Character.toLowerCase(cp);
            counts.put(lowerCp, counts.getOrDefault(lowerCp, 0) + 1);
            i += Character.charCount(cp);
        }

        for (int i = 0; i < s.length(); ) {
            int cp = s.codePointAt(i);
            int lowerCp = Character.toLowerCase(cp);

            if (counts.get(lowerCp) == 1) {
                return new String(Character.toChars(cp));
            }

            i += Character.charCount(cp);
        }

        return "";
    }
}
