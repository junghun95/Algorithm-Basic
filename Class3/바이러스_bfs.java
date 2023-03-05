package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_bfs {
    static boolean[] defect, chk;
    static int N, M;
    static int[][] connect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        defect = new boolean[N];
        connect = new int[M][2];
        chk = new boolean[M];
        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            connect[i][0] = Integer.parseInt(st.nextToken()) - 1;
            connect[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        bfs();
        int answer = 0;
        for (int i = 0; i < N; i++){
            if (defect[i]) answer++;
        }
        System.out.println(answer - 1);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        defect[0] = true;
        while (!q.isEmpty()){
            int temp = q.poll();
            for (int i = 0; i < M; i++){
                if (!chk[i]){
                    if (connect[i][0] == temp && !defect[connect[i][1]]){
                        q.offer(connect[i][1]);
                        defect[connect[i][1]] = true;
                        chk[i] = true;
                    } else if (connect[i][1] == temp && !defect[connect[i][0]]) {
                        q.offer(connect[i][0]);
                        defect[connect[i][0]] = true;
                        chk[i] = true;
                    }

                }
            }
        }
    }
}
