package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int result = 1;

        if(V == A) result = 1;
        else if((V - A) % (A - B) == 0) result = ((V - A) / (A - B)) + 1;
        else result = ((V - A) / (A - B)) + 2;
//
//        while (true) {
//            if(A * result - B * (result - 1) >= V) break;
//            result++;
//        }
        System.out.println(result);
    }
}
