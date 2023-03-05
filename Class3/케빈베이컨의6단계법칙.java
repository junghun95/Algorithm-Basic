package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {
    static boolean[][] edge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edge = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edge[x][y] = true;
            edge[y][x] = true;
        }
        int[] answer = new int[N+1];
        for (int i = 1; i <= N; i++){
            int[] sum = new int[N+1];
            for (int j = 1; j <= N; j++){
                if(i == j) continue;
                boolean[] chk = new boolean[N+1];
                bfs(i,j,sum, chk);
            }
            for (int s : sum){
                answer[i] += s;
            }
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= N; i++){
            if(answer[i] < min){
                min = answer[i];
                result = i;
            }
        }
        System.out.println(result);
    }

    private static void bfs(int i, int j, int[] sum, boolean[] chk) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i,0});
        chk[i] = true;

        while (!q.isEmpty()){
            int[] t = q.poll();
            if(t[0] == j) {
                sum[j] = t[1];
                break;
            }
            for (int k = 1; k < chk.length; k++){
                if(edge[t[0]][k] && !chk[k]){
                    q.offer(new int[]{k,t[1]+1});
                    chk[k] = true;
                }
            }
        }
    }
}
