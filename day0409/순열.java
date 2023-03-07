package day0409;

import java.util.Arrays;

public class 순열 {
    static int[] data, sel;
    static boolean[] visited;
    public static void main(String[] args) {
        data = new int[]{1, 2, 3};
        sel = new int[3];
        visited = new boolean[3];

        perm(0);

//        perm2(0, 0);

    }

//    private static void perm2(int idx, int visited) {
//        if (idx == 3){
//            System.out.println(Arrays.toString(sel));
//            return;
//        }
//        for (int i = 0; i < 3; i++){
//            if((visited & (1 << i)) > 0){
//                continue;
//            }
//            sel[idx] = data[i];
//            perm2(idx + 1, visited | 1 << i);
//        }
//    }

    private static void perm(int idx) {
        if(idx == 3){
            System.out.println(Arrays.toString(sel));
            return;
        }
        for (int i = 0; i < 3; i++){
            if(visited[i]) continue;

            sel[idx] = data[i];
            visited[i] = true;
            perm(idx + 1);
            visited[i] = false;
        }

    }


}
