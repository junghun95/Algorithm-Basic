package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9){
                    q.offer(new int[]{i, j, 0});
                    map[i][j] = 0;
                }
            }
        }
        int sharkSize = 2, eat = 0, time = 0;
        while (true){
            LinkedList<int[]> fish = new LinkedList<>();
            int[][] dist = new int[n][n];
            while (!q.isEmpty()){
                int[] shark = q.poll();

                for (int i = 0; i < 4; i++){
                    int nx = shark[0] + dx[i];
                    int ny = shark[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                    if (map[nx][ny] <= sharkSize && dist[nx][ny] == 0){
                        dist[nx][ny] = dist[shark[0]][shark[1]] + 1;
                        q.offer(new int[]{nx, ny, dist[nx][ny]});
                        if (map[nx][ny] != 0 && map[nx][ny] < sharkSize){
                            fish.add(new int[]{nx, ny, dist[nx][ny]});
                        }
                    }
                }
            }

            if (fish.size() == 0){
                System.out.println(time);
                return;
            }

            int[] curFish = fish.get(0);
            for (int i = 1; i < fish.size(); i++){
                if (curFish[2] > fish.get(i)[2]){
                    curFish = fish.get(i);
                } else if (curFish[2] == fish.get(i)[2]){
                    if (curFish[0] > fish.get(i)[0]) curFish = fish.get(i);
                    else if (curFish[0] == fish.get(i)[0]) {
                        if (curFish[1] > fish.get(i)[1]) curFish = fish.get(i);
                    }
                }
            }

            time += curFish[2];
            eat++;
            if (eat == sharkSize){
                sharkSize++;
                eat = 0;
            }
            map[curFish[0]][curFish[1]] = 0;
            q.offer(new int[]{curFish[0], curFish[1], 0});
        }

    }
}
