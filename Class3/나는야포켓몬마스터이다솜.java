package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> name = new HashMap<>();
        HashMap<Integer, String> number = new HashMap<>();

        for (int i = 1; i <= N; i++){
            String pocket = br.readLine();
            name.put(pocket, i);
            number.put(i, pocket);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            String str = br.readLine();
            if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
                sb.append(number.get(Integer.parseInt(str))).append("\n");
            } else {
                sb.append(name.get(str)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
