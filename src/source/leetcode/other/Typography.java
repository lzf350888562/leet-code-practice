package source.leetcode.other;

import java.util.*;

/**
 * 面试题, 见readme no.1
 */
public class Typography {
    private static List<String> res = new ArrayList<>();
    private static final int N = 3;
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
            if(!isLineOrSquare(frm)){
                res.add(stringJoiner.toString() + "(共享坐标)");
            }
        }else{
            setFrm(frm, i, j+1, n);
            setFrm(frm, i + 1, 0, n);
        }
        frm[i][j] = 0;
    }

    public static boolean isLineOrSquare(int[][] frm){
        if(frm[N-1][0] == 1 || frm[0][N-1] == 1){
            return true;
        }
        int sqrt = (int)Math.sqrt(N);
        int nTmp = sqrt * sqrt;
        if(N == nTmp){
            for (int i = 0; i < sqrt; i++) {
                for (int j = 0; j < sqrt; j++) {
                    if(frm[i][j] == 0){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
