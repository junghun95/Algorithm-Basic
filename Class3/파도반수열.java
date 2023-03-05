package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {
    static Long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new Long[101];
        arr[1] = 1l;
        arr[2] = 1l;
        arr[3] = 1l;
        arr[4] = 2l;
        arr[5] = 2l;
        int cur = 5;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            if (n > cur){
                for (int i = cur + 1; i <= n; i++){
                    arr[i] = arr[i-2] + arr[i-3];
                }
                cur = n;
            }
            sb.append(arr[n]).append("\n");
//            sb.append(padovan(n)).append("\n");

        }
        System.out.println(sb);
    }
//
//    private static int padovan(int n) {
//        if (arr[n] == 0){
//            arr[n] = padovan(n-1) + padovan(n-5);
//        }
//        return arr[n];
//    }
}
