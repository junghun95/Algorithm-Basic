package algorithm.Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        boolean[] truth = new boolean[n+1];
        parents = new int[n+1];
        for (int i = 1; i < n+1; i++){
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++){
            truth[Integer.parseInt(st.nextToken())] = true;
        }

        ArrayList<Integer>[] peoples = new ArrayList[m];
        for (int i = 0; i < m; i++){
            peoples[i] = new ArrayList<>();
        }

        int pre = 0, value;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int member = Integer.parseInt(st.nextToken());
            if (member > 0){
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }
            for (int j = 1; j < member; j++){
                value = Integer.parseInt(st.nextToken());
                peoples[i].add(value);
                union(pre, value);
                pre = value;
            }
        }

        for (int i = 1; i < truth.length; i++){
            if (truth[i]){
                truth[find(i)] = true;
            }
        }

        int parent;
        for (int i = 0; i < m; i++){
            if (peoples[i].size() > 0){
                parent = find(peoples[i].get(0));
                if (!truth[parent]) answer++;
            }
        }

        System.out.println(answer);
    }

    private static int find(int x) {
        if (parents[x] == x) return parents[x] = x;
        else return find(parents[x]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b){
            if (a > b){
                parents[a] = b;
            } else parents[b] = a;

            return true;
        }
        return false;
    }


}
