package algorithm.Class2;

import java.util.Scanner;

public class 분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();
        int result = 0;
        for(int i = 0; i < N; i++){
            if(valid(i, N)){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean valid(int i, int n) {
        int m = i;
        while (true){
            if(i / 10 == 0){
                m += i;
                break;
            }

            m += i % 10;
            i /= 10;
        }
        if(m == n) return true;
        else return false;
    }
}
