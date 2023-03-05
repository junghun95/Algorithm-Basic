package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else {
                return Math.abs(o1) - Math.abs(o2);
            }
        }));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            int val = Integer.parseInt(br.readLine());

            if (val == 0){
                if (pq.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(val);
            }
        }
        System.out.println(sb);
    }
}
