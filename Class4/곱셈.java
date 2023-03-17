package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 곱셈 {
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(pow(a, b));
    }

    private static long pow(long a, long exp) {
        if (exp == 1){
            return a % c;
        }

        long temp = pow(a, exp / 2);

        if (exp % 2 == 1){
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;
    }
}
