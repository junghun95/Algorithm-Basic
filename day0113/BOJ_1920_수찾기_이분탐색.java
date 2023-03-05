package day0113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기_이분탐색 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            int temp = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(temp)).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int temp) {
        int l = 0;
        int h = arr.length - 1;
        while (true){
            int mid = (l + h) / 2;
            if(arr[mid] == temp){
                return 1;
            } else if (arr[mid] > temp){
                h = mid - 1;
            } else if (arr[mid] < temp){
                l = mid + 1;
            }

            if(h < l) return 0;
        }
    }
}
