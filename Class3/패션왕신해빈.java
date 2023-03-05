package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                String part = st.nextToken();
                if (map.containsKey(part)){
                    map.put(part, map.get(part) + 1);
                } else {
                    map.put(part, 1);
                }
            }

            Set<String> set = map.keySet();
            int[] value = new int[set.size()];
            int i = 0;
            for (String p : set){
                value[i] = map.get(p);
                i++;
            }

            int answer = 1;
            for (int j = 0; j < value.length; j++){
                answer *= (value[j] + 1);
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }
}
