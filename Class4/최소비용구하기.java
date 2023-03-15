package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
    static ArrayList<ArrayList<Node>> a;
    static int[] dist;
    static boolean[] visited;
    static int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        a = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            a.add(new ArrayList<>());
        }
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, INF);
        StringTokenizer st;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));

    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]){
                visited[cur] = true;

                for (Node node : a.get(cur)){
                    if (!visited[node.end] && dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        pq.offer(new Node(node.end, dist[node.end]));
                    }
                }
            }

        }
        return dist[end];
    }

    private static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
