package algorithm.Class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 랜선자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            int a = sc.nextInt();
            min = min > a ? a : min;
            list.add(a);
        }
        sc.close();
        for (int i = min; i > 0; i--){
            int temp = 0;
            for(int j = 0; j < list.size(); j++){
                temp += list.get(j) / i;
            }
            if(temp >= n){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
