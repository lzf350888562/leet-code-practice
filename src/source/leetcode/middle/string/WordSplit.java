package source.leetcode.middle.string;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * no.139 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 */
public class WordSplit {
    public boolean wordBreak(String s, List<String> wordDict) {
        BitSet bitSet = new BitSet(s.length());
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i != 0 && j != 0) {
                    if (bitSet.get(j - 1) && wordDict.contains(s.substring(j, i + 1))) {
                        bitSet.set(i);
                        break;
                    }
                } else {
                    if (wordDict.contains(s.substring(j, i + 1))) {
                        bitSet.set(i);
                        break;
                    }
                }
            }
        }
        return bitSet.get(s.length() - 1);
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        int length = s.length();
        BitSet bitSet = new BitSet(s.length() + 1);
        bitSet.set(0);
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (bitSet.get(j) && wordDict.contains(s.substring(j, i))) {
                    bitSet.set(i);
                    break;
                }
            }
        }
        return bitSet.get(s.length());
    }

    public static void main(String[] args) {
//        System.out.println(new WordSplit().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordSplit().wordBreak1("leetcode", Arrays.asList("leet", "code")));

    }
}
