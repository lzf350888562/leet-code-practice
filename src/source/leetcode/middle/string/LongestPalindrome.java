package source.leetcode.middle.string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author lzf
 * @date 2021/10/5
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
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
