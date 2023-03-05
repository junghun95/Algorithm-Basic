package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                pq.offer(num);
            } else {
                if(!pq.isEmpty()){
                    sb.append(pq.poll()+ "\n");
                } else {
                    sb.append(0+"\n");
                }
            }
        }
        System.out.println(sb);
    }
}
