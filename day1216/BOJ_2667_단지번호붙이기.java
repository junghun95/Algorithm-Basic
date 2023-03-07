package day1216;

import java.io.*;
import java.util.*;

public class BOJ_2667_단지번호붙이기 {
    static int n, cnt;
    static int[][] map;
    static boolean[][] chk;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        n = sc.nextLine().charAt(0) - '0';
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        chk = new boolean[n][n];
        for(int i = 0; i < n; i++){
//            String str = sc.nextLine();
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
//        sc.close();
        ArrayList<Integer> list = new ArrayList<>();

        int num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && !chk[i][j]){
                    cnt = 0;
                    num++;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(num);
        for (Integer i : list){
            System.out.println(i);
        }

    }

    public static void dfs(int x, int y) {
        chk[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n && !chk[nx][ny] && map[nx][ny] == 1){
                chk[nx][ny] = true;


                dfs(nx, ny);
            }
        }
    }
}
