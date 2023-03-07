package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[8001];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int median = 10000;
        int mod = 10000;

        for(int i = 0; i < N; i++){
            int val = Integer.parseInt(br.readLine());
            sum += val;
            count[val + 4000]++;
            if(val < min) min = val;
            if(val > max) max = val;

        }


        int cnt = 0;
        int mod_max = 0;
        boolean flag = false;
        for (int i = min + 4000; i <= max + 4000; i++){
            if(count[i] > 0){


                if(cnt < (N + 1) / 2) {
                    cnt += count[i];
                    median = i - 4000;
                }

                if(mod_max < count[i]){
                    mod_max = count[i];
                    mod = i - 4000;
                    flag = true;
                } else if(mod_max == count[i] && flag){
                    mod = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int) Math.round((double) sum/N));
        System.out.println(median);
        System.out.println(mod);
        System.out.println(max - min);
    }
}
