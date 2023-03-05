package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            Queue<Integer> q = new LinkedList<>();
            q.offer(a);
            visited[a] = true;
            command[a] = "";

            while (!q.isEmpty()){
                int now = q.poll();

                if (now == b){
                    sb.append(command[b]).append("\n");
                    break;
                }

                int D = (now * 2) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = now % 1000 * 10 + now / 1000;
                int R = now / 10 + now % 10 * 1000;

                if (!visited[D]){
                    q.offer(D);
                    command[D] = command[now] + "D";
                    visited[D] = true;
                }
                if (!visited[S]){
                    q.offer(S);
                    command[S] = command[now] + "S";
                    visited[S] = true;
                }
                if (!visited[L]){
                    q.offer(L);
                    command[L] = command[now] + "L";
                    visited[L] = true;
                }
                if (!visited[R]){
                    q.offer(R);
                    command[R] = command[now] + "R";
                    visited[R] = true;
                }

            }

        }
        System.out.println(sb);
    }
}
