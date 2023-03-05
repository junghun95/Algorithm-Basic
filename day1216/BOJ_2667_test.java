package day1216;
import java.util.*;
import java.io.*;

public class BOJ_2667_test {
    static int map[][];
    static boolean chk[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static int cnt = 0, num = 0;
    static int nowX, nowY, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        chk = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String str = br.readLine();

            for(int j=0; j<n; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                if(chk[i][j] == false && map[i][j] == 1) {
                    cnt = 0;
                    num++;
                    DFS(i, j);
                    list.add(cnt);
                }

            }
        }

        Collections.sort(list);
        bw.append(num + "\n");
        for(int num : list) {
            bw.append(num + "\n");
        }

        bw.flush();
        bw.close();
    } // End of main

    static void DFS(int x, int y) {
        chk[x][y] = true;
        map[x][y] = num;
        cnt ++;

        for(int i=0; i<4; i++) {
            nowX = dx[i] + x;
            nowY = dy[i] + y;

            if(Range_check() && chk[nowX][nowY] == false && map[nowX][nowY] == 1) {
                chk[nowX][nowY] = true;
                map[nowX][nowY] = num;

                DFS(nowX, nowY);
            }
        }

    } // End of DFS

    static boolean Range_check() {
        return (nowX >= 0 && nowX < n && nowY >= 0 && nowY < n);
    } // End of Range_check
} // End of class

