package source.leetcode.middle.combination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17  回溯
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射与电话按键9宫格相同。注意 1 不对应任何字母。
 * @author lzf
 * @date 2021/10/6
 */
public class LetterCombinations {
    private static Map<Character, String> phoneMap = new HashMap<>();
    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }
    private static StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if("".equals(digits)){
            return res;
        }
        doCombination(digits,res,0);
        return res;
    }
    public void doCombination(String digits, List<String> res, int i){
        if(i == digits.length()){
            res.add(sb.toString());
            return ;
        }
        for (int j = 0; j < phoneMap.get(digits.charAt(i)).length(); j++) {
            sb.append(phoneMap.get(digits.charAt(i)).charAt(j));
            doCombination(digits,res,i+1);
            sb.deleteCharAt(i);
        }
    
    }
    
    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
