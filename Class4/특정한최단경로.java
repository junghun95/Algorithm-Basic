package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {
    static int INF = 200000000;
    static ArrayList<ArrayList<Node>> a;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        visited = new boolean[n+1];
        a = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            a.add(new ArrayList<>());
        }
        Arrays.fill(dist, INF);
        for (int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, cost));
            a.get(end).add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int cost1 = 0;
        cost1 += dijkstra(1, v1);
        cost1 += dijkstra(v1, v2);
        cost1 += dijkstra(v2, n);

        int cost2 = 0;
        cost2 += dijkstra(1, v2);
        cost2 += dijkstra(v2, v1);
        cost2 += dijkstra(v1, n);

        int answer = Math.min(cost1, cost2);
        if (answer >= INF){
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

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
                        pq.add(new Node(node.end, dist[node.end]));
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
