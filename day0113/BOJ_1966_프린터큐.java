package day0113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < N; i++){
                q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            int count = 0;
            // q[i][0] == M 인 원소가 언제 출력되는지 확인하기
            while (!q.isEmpty()){
                int[] test = q.poll();
                boolean isMax = true;

                for (int i = 0; i < q.size(); i++){
                    if(test[1] < q.get(i)[1]){
                        q.offer(test);

                        for(int j = 0; j < i; j++){
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }

                }

                if(isMax == false) {
                    continue;
                }

                count++;
                if(M == test[0]){
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
