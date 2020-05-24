package context190;


class Solution {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence.isEmpty()) {
            return -1;
        }
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < searchWord.length()) {
                continue;
            }
            if (s[i].substring(0, searchWord.length()).equals(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        isPrefixOfWord("i love eating burger","burg");
    }
}
