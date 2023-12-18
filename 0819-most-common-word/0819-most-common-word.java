class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> result = new HashMap<>();

        paragraph = paragraph.replaceAll("\\W+", " ").toLowerCase();

        String[] words = paragraph.split(" ");

        for (int i = 0; i < words.length; i++) {
            boolean isBanned = false;

            for (int j = 0; j < banned.length; j++) {
                if (words[i].equals(banned[j])) {
                    isBanned = true;
                    break;
                }
            }

            if (!isBanned) {
                if (!result.containsKey(words[i])) {
                    result.put(words[i], 1);
                } else {
                    int currentCount = result.get(words[i]);
                    result.put(words[i], currentCount + 1);
                }
            }
        }

        int maxCount = 0;
        String maxWord = "";
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        return maxWord;
    }
}