package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] score = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dpMax = new int[n][3];
        int[][] dpMin = new int[n][3];

        dpMax[0] = score[0];
        dpMin[0] = score[0];

        for (int i = 1; i < n; i++){
            dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + score[i][0];
            dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + score[i][0];
            dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + score[i][1];
            dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + score[i][1];
            dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + score[i][2];
            dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + score[i][2];
        }

        int[] minAns = dpMin[n-1];
        int[] maxAns = dpMax[n-1];

        Arrays.sort(minAns);
        Arrays.sort(maxAns);

        System.out.println(maxAns[2] + " " + minAns[0]);
    }
}
