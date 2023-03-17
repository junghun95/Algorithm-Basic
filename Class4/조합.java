package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        BigInteger up = BigInteger.ONE;
        BigInteger down = BigInteger.ONE;
        for (int i = 0; i < m; i++){
            up = up.multiply(new BigInteger(String.valueOf(n-i)));
            down = down.multiply(new BigInteger(String.valueOf(i+1)));
        }
        System.out.println(up.divide(down));
    }
}
