package source.leetcode.esay.string;

/**
 * 168. Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * @author lzf
 * @date 2021/10/4
 */
public class ExcelConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber!=0){
            int i = columnNumber % 26;
            if(i == 0 ){
                stringBuilder.append('Z');
                columnNumber-= 26;
            }else{
                stringBuilder.append((char)(65+i-1));
            }
//            if(columnNumber==26){
//                break;
//            }
            columnNumber /= 26;
        }
        return stringBuilder.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new ExcelConvertToTitle().convertToTitle(701));
    }
    
    public String convertToTitle2(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }
}
