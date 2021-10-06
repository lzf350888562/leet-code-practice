package source.leetcode.middle.string;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 22
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * @author lzf
 * @date 2021/10/6
 */
public class GenerateParenthesis {
    List[] cache = new ArrayList[100];
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        List<StringBuilder> sbs = doGenerate(n);
        return sbs.stream().map(sb ->sb.toString()).collect(Collectors.toList());
    }
    
    private List<StringBuilder> doGenerate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        List<StringBuilder> sbs = new ArrayList<>();
        if (n == 0) {
            sbs.add(new StringBuilder(""));
        } else {
            for (int c = 0; c < n; ++c) {
                for (StringBuilder left: doGenerate(c)) {
                    for (StringBuilder right: doGenerate(n - 1 - c)) {
                        sbs.add(new StringBuilder("(").append(left).append(")").append(right));
                    }
                }
            }
        }
        cache[n] = sbs;
        return sbs;
    }
    
    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
