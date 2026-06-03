public class TwoToOne {
    public static String longest(String s1, String s2) {
        int mask = 0;

        for (int i = 0; i < s1.length(); i++) {
            mask |= 1 << (s1.charAt(i) - 'a');
        }

        for (int i = 0; i < s2.length(); i++) {
            mask |= 1 << (s2.charAt(i) - 'a');
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if ((mask & (1 << i)) != 0)
                result.append((char) ('a' + i));
        }

        return result.toString();
    }
}