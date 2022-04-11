package source.leetcode.middle.string;

/**
 * 5. 最长回文子串
 * @author lzf
 * @date 2021/10/5
 */
public class LongestPalindrome {
    /**
     * 解法优化升级 1  双指针
     * 如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符
     * @date 2022/04/10
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
     * 如果 l==r 为奇数回文的情况
     */
    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
    public String longestPalindrome1(String s) {
        String res = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            //aba型
            for (int j = 1;;j++) {
                if(i-j<0||i+j>=s.length()||s.charAt(i-j) != s.charAt(i+j)){
                    String t = s.substring(i - j + 1, i + j);
                    res = res.length()>t.length()?res: t;
                    break;
                }
            }
            //aabb型
            for (int j = 1;; j++) {
                if(i-j<0||i+j-1>=s.length()||s.charAt(i-j) != s.charAt(i+j-1)){
                    String t = s.substring(i - j + 1, i + j-1);
                    res = res.length()>t.length()?res: t;
                    break;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }
}
