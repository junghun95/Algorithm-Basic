package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(isPrime(num)){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int num) {
        if(num == 0 || num == 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
