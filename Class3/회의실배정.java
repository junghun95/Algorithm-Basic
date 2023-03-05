package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) ->{
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] schedule = new int[2];
            schedule[0] = Integer.parseInt(st.nextToken());
            schedule[1] = Integer.parseInt(st.nextToken());
            pq.offer(schedule);
        }

        int size = pq.size();
        int end = 0;
        int cnt = 0;
        for (int i = 0; i < size; i++){
            int[] temp = pq.poll();
            if(end <= temp[0]){
                cnt++;
                end = temp[1];
            }
        }
        System.out.println(cnt);

    }

}
