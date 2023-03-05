package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] map = new int[15][15];
        for (int i = 0 ; i < 15; i++){
            map[0][i] = i;
            map[i][1] = 1;

        }

        for (int i = 1; i < 15; i++){
            for (int j = 2; j < 15; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++){
//            Long k = Long.parseLong(br.readLine());
//            Long n = Long.parseLong(br.readLine());
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(map[k][n]).append("\n");
//            Long result = fact(k+n) / (fact(k+1) * fact(n-1));
//            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static Long fact(Long i) {
        if(i == 0L || i == 1L) return 1L;
        Long answer = i;
        while (i-- > 1){
            answer *= i;
        }
        return answer;
    }
}
