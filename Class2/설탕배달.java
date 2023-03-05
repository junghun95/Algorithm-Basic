package class2;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        int f = N / 5;
        int t = 0;
        while (true) {
            if(f < 0){
                result = -1;
                break;
            }
            if((N - f * 5) % 3 == 0){
                t = (N - f * 5) / 3;
                result = f + t;
                break;
            }
            f--;
        }
        System.out.println(result);
    }
}
