class Solution {
    int left, maxLen;
    public void extend(String s, int l, int r) {

        // 펠린 드롬을 매칭할 때 까지 l(왼쪽)과 r(오른쪽)을 이동시킨다.
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        if (maxLen < r - l - 1) {
            left = l + 1;
            maxLen = r - l - 1;
        }
    }

    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            extend(s, i, i+1);
            extend(s, i, i+2);
        }

        return s.substring(left, left + maxLen);
    }
}