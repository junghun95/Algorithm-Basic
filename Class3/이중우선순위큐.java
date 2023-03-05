package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap();

            for (int i = 0; i < k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("I")){
                    int value = Integer.parseInt(st.nextToken());
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    int value = Integer.parseInt(st.nextToken());
                    int key = value == 1 ? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);

                    if (cnt == 1){
                        map.remove(key);
                    } else {
                        map.put(key, cnt - 1);
                    }
                }
            }

            if (map.isEmpty()){
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
