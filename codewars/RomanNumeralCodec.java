public class RomanNumeralCodec {
    private static final int[] VALUES = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    private static final String[] ROMANS = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static String toRoman(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < VALUES.length; i++) {
            while (n >= VALUES[i]) {
                sb.append(ROMANS[i]);
                n -= VALUES[i];
            }
        }

        return sb.toString();
    }

    public static int fromRoman(String s) {
        int result = 0;
        int i = 0;

        for (int j = 0; j < ROMANS.length; j++) {
            while (s.startsWith(ROMANS[j], i)) {
                result += VALUES[j];
                i += ROMANS[j].length();
            }
        }

        return result;
    }
}