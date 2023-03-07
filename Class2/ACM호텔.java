package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int y = N % H;
            if(y == 0) y = H;
            int x = 0;
            if(N % H == 0){
                x = N / H;
            } else{
                x = (N / H) + 1;
            }
            int result = y * 100 + x;
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
