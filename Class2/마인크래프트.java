package algorithm.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max) max = map[i][j];
                if (map[i][j] < min) min = map[i][j];
            }
        }

        int answerSeconds = Integer.MAX_VALUE;
        int answerHeight = -1;
        for (int i = min; i <= max; i++){
            int seconds = 0;
            int inven = B;

            for (int j = 0; j < N; j++){
                for (int k = 0; k < M; k++){
                    int diff = map[j][k] - i;
                    if(diff > 0){
                        seconds += Math.abs(diff) * 2;
                        inven += Math.abs(diff);
                    } else if (diff < 0) {
                        seconds += Math.abs(diff);
                        inven -= Math.abs(diff);
                    }
                }
            }

            if(inven >= 0){
                if (seconds <= answerSeconds){
                    answerSeconds = seconds;
                    answerHeight = i;
                }
            }
        }
        System.out.println(answerSeconds + " " + answerHeight);
    }
}
