package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++){
            set.add(br.readLine());
        }
        PriorityQueue<String> answer = new PriorityQueue<>();
        for (int i = 0; i < M; i++){
            String str = br.readLine();
            if(set.contains(str)){
                answer.offer(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size() + "\n");
        while (!answer.isEmpty()){
            sb.append(answer.poll() + "\n");
        }
        System.out.println(sb);
    }
}
