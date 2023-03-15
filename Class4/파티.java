package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {
    static int answer = 0, n, x, INF = 1000000000;
    static int[][] cost;
    static ArrayList<ArrayList<Node>> arrList, reverse_arrList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arrList = new ArrayList<>();
        reverse_arrList = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            arrList.add(new ArrayList<>());
            reverse_arrList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arrList.get(start).add(new Node(end, weight));
            reverse_arrList.get(end).add(new Node(start, weight));
        }

        int[] dist = dijkstra(arrList);
        int[] reverse_dist = dijkstra(reverse_arrList);
        int answer = 0;
        for (int i = 1; i <= n; i++){
            answer = Math.max(answer, dist[i] + reverse_dist[i]);
        }
        System.out.println(answer);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Node>> a) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[x] = 0;

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
        return dist;
    }

    public static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
