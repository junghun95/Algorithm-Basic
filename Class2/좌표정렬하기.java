package algorithm.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1.x == o2.x){
                return o1.y - o2.y;
            } else {
                return o1.x - o2.x;
            }
        }));
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            Point p = pq.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        System.out.println(sb);
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

//        @Override
//        public int compareTo(Point o){
//            if(this.x < o.x) return -1;
//            else if (this.x > o.x) return 1;
//            else {
//                if(this.y < o.y) return -1;
//                else if (this.y > o.y) return 1;
//                else return 0;
//            }
//        }
    }
}
