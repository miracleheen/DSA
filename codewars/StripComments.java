public class StripComments {

    public static String stripComments(String text, String[] commentMarkers) {
        return Arrays.stream(text.split("\n", -1))
                .map(line -> {
                    int cut = line.length();
                    for (String marker : commentMarkers) {
                        int pos = line.indexOf(marker);
                        if (pos != -1 && pos < cut) {
                            cut = pos;
                        }
                    }
                    return rtrim(line.substring(0, cut));
                })
                .collect(Collectors.joining("\n"));
    }

    private static String rtrim(String s) {
        int end = s.length();
        while (end > 0 && Character.isWhitespace(s.charAt(end - 1))) {
            end--;
        }
        return s.substring(0, end);
    }
}