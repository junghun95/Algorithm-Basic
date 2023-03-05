package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        loop:
        while (T-- > 0){
            String order = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, "[],");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            boolean front = true;
            for (int i = 0; i < order.length(); i++){
                char c = order.charAt(i);
                if (c == 'R') front = !front;
                else {
                    if (list.isEmpty()){
                        sb.append("error\n");
                        continue loop;
                    } else if (front){
                        list.remove(0);
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
            }
            sb.append("[");
            if (front){
                for (int i = 0; i < list.size(); i++){
                    if (i == list.size() - 1) sb.append(list.get(i));
                    else sb.append(list.get(i) + ",");
                }
            } else {
                for (int i = list.size() - 1; i >= 0; i--){
                    if (i == 0) sb.append(list.get(i));
                    else sb.append(list.get(i) + ",");
                }
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}
