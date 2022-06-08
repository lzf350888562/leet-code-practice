package source.leetcode.other;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * 面试题, 见readme no.1
 */
public class Typography {
    private static Set<String> res = new HashSet<>();
    private static int N = 4;
    public static void main(String[] args) {
        int[][] frm = new int[N][N];
        for (int i = 0; i < frm.length; i++) {
            frm[i] = new int[N];
        }
        int n = 0;
        setFrm(frm, 0, 0, n);
        for (String re : res) {
            System.out.println(re);
        }
    }
    public static void setFrm(int[][] frm, int i, int j, int n){
        frm[i][j] = 1;
        n++;
        if( n == N ){
            StringJoiner stringJoiner = new StringJoiner(",");
            for (int[] ints : frm) {
                for (int anInt : ints) {
                    stringJoiner.add(String.valueOf(anInt));
                }
            }
            res.add(stringJoiner.toString());
        }else{
            setFrm(frm, i, j+1, n);
            setFrm(frm, i + 1, 0, n);
        }
        frm[i][j] = 0;
    }
}
