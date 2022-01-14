package source.leetcode.esay.string;

import java.util.Collections;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int sum = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || sum != 0){
            if(i>=0) sum += num1.charAt(i--)-'0';
            if(j>=0) sum += num2.charAt(j--)-'0';
            res.append(sum%10);
            sum /= 10;
        }
        return res.reverse().toString();
    }
}
