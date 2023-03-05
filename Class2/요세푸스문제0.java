package algorithm.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++){
            arr.add(i);
        }
        int pos = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (arr.size() != 0){
            pos += K - 1;
            if(pos >= arr.size()){
                pos %= arr.size();
            }
            if(arr.get(pos) == 0) {
                sb.append(N).append(", ");
                arr.remove(pos);
            }
            else sb.append(arr.remove(pos)).append(", ");
        }
        sb.replace(sb.length()-2, sb.length(), "");
        sb.append(">");
        System.out.println(sb);
    }
}
