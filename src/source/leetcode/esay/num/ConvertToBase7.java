package source.leetcode.esay.num;

/**
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 */
public class ConvertToBase7 {
    /**
     * 除法和取模
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean is_negative = num < 0;
        if (is_negative) num = -num;
        String ans = "";
        while (num != 0) {
            int a = num / 7, b = num % 7;
            ans = b + ans;
            num = a;
        }
        return is_negative? "-" + ans: ans;
    }
}
