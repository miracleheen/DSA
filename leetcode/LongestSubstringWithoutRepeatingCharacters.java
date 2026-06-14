class LongestSubstringWithoutRepeatingCharacters{
     public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastPos = new HashMap<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastPos.containsKey(current)) {
                left = Math.max(left, lastPos.get(current) + 1);
            }

            lastPos.put(current, right);
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}