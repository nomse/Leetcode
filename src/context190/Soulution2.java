package context190;

class Solution2 {
    public static int maxVowels(String s, int k) {
        String yuan = "aeiou";
        String init = s.substring(0, k);
        int initRes = 0;
        for (int i = 0; i < init.length(); i++) {
            if (isyuan(yuan, init, i)) {
                initRes++;
            }
        }
        int maxRes = initRes;
        for (int i = 1; i < s.length() - k + 1; i++) {
            if (isyuan(yuan, s, i - 1)) {
                initRes--;
            }
            if (isyuan(yuan, s, i + k - 1)) {
                initRes++;
            }
            maxRes = Math.max(maxRes, initRes);
        }
        return maxRes;
    }

    private static boolean isyuan(String yuan, String s, int i) {
        return yuan.indexOf(s.charAt(i)) != -1;
    }

    public static void main(String[] args) {
        maxVowels("weallloveyou", 7);
    }
}
