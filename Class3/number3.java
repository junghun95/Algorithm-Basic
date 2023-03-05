package algorithm.Class3;

import java.util.LinkedList;
import java.util.Queue;

public class number3 {
    public static void main(String[] args) {
        int[][] macaron = new int[][]{{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
        for (int i = 0; i < 6; i++){
            System.out.println(solution(macaron)[i]);
        }
    }

    static int[][] map;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] height;
    public static String[] solution(int[][] macaron) {
        String[] answer = new String[6];
        map = new int[6][6];
        height = new int[6];
        for (int i = 0; i < macaron.length; i++){
            map[5 - height[macaron[i][0]-1]][macaron[i][0]-1] = macaron[i][1];

            height[macaron[i][0] - 1]++;

            boolean flag = false;
            while (!flag){

                // 세개이상 붙어있는 블럭 체크해서 터치기
                boolean[][] chk = new boolean[6][6];
                flag = true;
                for (int j = 0; j < 6; j++){
                    for (int k = 0; k < 6; k++){
                        if(map[j][k] == 0) continue;
                        boolean[][] visited = new boolean[6][6];
                        if(bfs(j, k, visited)){
                            bomb(j,k,chk, map[j][k]);
                            flag = false;
                        }
                    }
                }

                // 없어진 블럭있다면 아래로 채우기
                if(!flag){
                    boolean[] flat = new boolean[6];
                    while (true){
                        boolean sum = true;
                        for (int j = 0; j < 6; j++){
                            if(!flat[j]){
                                sum = false;
                                boolean p = true;
                                for (int k = 0; k < 5; k++){
                                    if(map[k][j] != 0 && map[k+1][j] == 0){
                                        map[k+1][j] = map[k][j];
                                        map[k][j] = 0;
                                        p = false;
                                    }
                                }
                                if(p){
                                    flat[j] = true;
                                }
                            }
                        }
                        if (sum) break;
                    }
                }

            }
        }
        for (int i = 0; i < 6; i++){
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 6; j++){
                sb.append(map[i][j]);
            }
            answer[i] = sb.toString();

        }

        return answer;
    }

    private static void bomb(int x, int y, boolean[][] chk, int color) {
        chk[x][y] = true;
        map[x][y] = 0;
        height[y]--;
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 6 && ny >= 0 && ny < 6){
                if(map[nx][ny] == color && !chk[nx][ny]){
                    bomb(nx, ny, chk, color);
                }
            }
        }
    }

    private static boolean bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 1;
        while (!q.isEmpty()){
            int[] pos = q.poll();
            if(cnt >= 3) return true;
            for (int i = 0; i < 4; i++){
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx >= 0 && nx < 6 && ny >= 0 && ny < 6){
                    if (map[nx][ny] != 0 && !visited[nx][ny]){
                        if (map[x][y] == map[nx][ny]){
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            cnt++;
                        }
                    }
                }
            }
        }
        return false;

    }
}
