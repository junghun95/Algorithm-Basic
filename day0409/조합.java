package day0409;

import java.util.Arrays;

public class 조합 {
    static int[] data, sel;
    static int n, r;
    public static void main(String[] args) {
        data = new int[]{1,2,3,4};
        sel = new int[2];
        n = data.length;
        r = sel.length;
        comb(0,0);

    }

    private static void comb(int idx, int sidx) {
        if(sidx == r){
            System.out.println(Arrays.toString(sel));
            return;
        }
        if(idx >= n) return;
        sel[sidx] = data[idx];
        comb(idx + 1, sidx + 1);
        comb(idx + 1, sidx);

    }

}
