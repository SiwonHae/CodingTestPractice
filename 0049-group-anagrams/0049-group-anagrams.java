class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = String.valueOf(chars);

            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }

            m.get(key).add(s);
        }

        return new ArrayList<>(m.values());
    }
}