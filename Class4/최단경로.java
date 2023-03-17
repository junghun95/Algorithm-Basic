package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {
    static ArrayList<ArrayList<Node>> a;
    static int[] dist;
    static boolean[] visited;
    static int INF = 3000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        a = new ArrayList<>();
        for (int i = 0; i <= v; i++){
            a.add(new ArrayList<>());
        }
        dist = new int[v+1];
        visited = new boolean[v+1];
        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            a.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        dijkstra(start);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= v; i++){
            if (dist[i] >= INF){
                sb.append("INF\n");
            }else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, INF);
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
    }

    private static class Node implements Comparable<Node>{
        int end;
        int weight;

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
