package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        int len = 1;
        for (int i = 0; i < N; i++){
            len *= 2;
        }

        while (true){
//            if(len == 0) break;
            int block = (len / 2) * (len / 2);
            if(block == 1){
                answer += r*2 + c + 1;
                break;
            }
            if(r < len / 2 && c < len / 2){ // 1사분면

            } else if (r < len / 2 && c >= len / 2) { // 2사분면
                answer += block;
                c -= len / 2;
            } else if (r >= len / 2 && c < len / 2) { // 3사분면
                answer += block * 2;
                r -= len / 2;
            } else if (r >= len / 2 && c >= len / 2) { // 4사분면
                answer += block * 3;
                r -= len / 2;
                c -= len / 2;
            }
            len /= 2;
        }
        System.out.println(answer - 1);
    }
}
