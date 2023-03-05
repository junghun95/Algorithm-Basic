package algorithm.Class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        while (q.size() != 1){
            // 1개 버리고
            q.poll();

            // 1개 꺼내서 맨뒤로
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}
