package leetcode5;

/**
 * 中心扩散法
 * 考虑以单个中心和两个中心进行左右扩散
 * 这种方式一共有n+(n-1)种中心可能性
 * 只需要保存结束位置和len长度即可
 * 将最长的回文子串长度设为全局
 */

class Solution {
    private static int maxLen = 0;
    private static String longestPalindrome = "";

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            getLongestPalindrome(i, i, s);
            getLongestPalindrome(i, i + 1, s);
        }
        getLongestPalindrome(s.length() - 1, s.length() - 1, s);
        return longestPalindrome;
    }

    private static void getLongestPalindrome(int i, int i1, String s) {
        while (i >= 0 && i1 < s.length() && s.charAt(i) == s.charAt(i1)) {
            i--;
            i1++;
        }
        if (i1 - i + 1 > maxLen) {
            longestPalindrome = s.substring(i+1, i1);
        }
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
}
