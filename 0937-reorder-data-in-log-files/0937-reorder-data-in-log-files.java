class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
        // dig1, let1, dig2, let2, let3는 식별자.

        List<String> letterLog = new ArrayList<>();
        List<String> digitLog = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            if (Character.isDigit(logs[i].split(" ")[1].charAt(0))) {
                digitLog.add(logs[i]);
            } else if (Character.isLetter(logs[i].split(" ")[1].charAt(0))) {
                letterLog.add(logs[i]);
            }
        }

        letterLog.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 오름차순으로 정렬한다.
                // s1 > s2면 리턴 값이 양수다. (자리 바꾼다.)
                // s1 < s2면 리턴 값이 음수다. (자리 유지한다.)
                // s1 == s2면 리턴 값이 0이다. (자리 유지)

                String[] str1 = s1.split(" ", 2); // 2개의 배열로 나눈다. (식별자, 로그 내용)
                String[] str2 = s2.split(" ", 2);

                if (str1[1].compareTo(str2[1]) == 0) {
                    // 로그 문자가 같을 때는 식별자순으로
                    return str1[0].compareTo(str2[0]);
                } else {
                    return str1[1].compareTo(str2[1]);
                }
            }
        });

        letterLog.addAll(digitLog);

        return letterLog.toArray(new String[0]);
    }
}