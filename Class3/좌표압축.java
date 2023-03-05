package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            sorted[i] = a;
        }
        Arrays.sort(sorted);
        int cnt = 0;
        for (int i = 0; i <n; i++){
            if (!map.containsKey(sorted[i])){
                map.put(sorted[i], cnt);
                cnt++;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);

    }
}
