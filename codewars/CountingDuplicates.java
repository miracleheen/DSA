public class CountingDuplicates {
     public static int duplicateCount(String text) {
        int[] count = new int[36];

        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));

            int index;
            if (ch >= '0' && ch <= '9') {
                index = ch - '0';
            } else {
                index = 10 + (ch - 'a');
            }

            count[index]++;
        }

        int duplicates = 0;
        for (int c : count) {
            if (c > 1) {
                duplicates++;
            }
        }

        return duplicates;
    }
}
