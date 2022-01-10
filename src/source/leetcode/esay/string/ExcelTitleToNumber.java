package source.leetcode.esay.string;

/**
 * 171. Excel 表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 * @author lzf
 * @date 2021/10/4
 */
public class ExcelTitleToNumber {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            sum+=(columnTitle.charAt(i)-'A'+1)*Math.pow(26,columnTitle.length()-1-i);
        }
        return sum;
    }
}
