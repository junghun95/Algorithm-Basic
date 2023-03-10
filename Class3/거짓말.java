package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 거짓말 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean[] truth = new boolean[n+1];
        int person = Integer.parseInt(st.nextToken());
        for (int i = 0; i < person; i++){
            truth[Integer.parseInt(st.nextToken())] = true;
        }
        int answer = 0;
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            LinkedList<Integer> subList = new LinkedList<>();
            for (int j = 0; j < num; j++){
                subList.add(Integer.parseInt(st.nextToken()));
            }
            list.add(subList);
        }

        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++){
            LinkedList<Integer> party = list.get(i);
            visited[i] = true;

            boolean flag = false;
            for (int j = 0; j < party.size(); j++){
                if (truth[party.get(j)]){
                    flag = true;

                }
            }
        }


        System.out.println(answer);
    }
}
