package algorithm.Class2;

import java.util.Scanner;

public class 벌집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int m = (N - 1) / 6;
        if((N - 1) % 6 != 0) m++;
        if(N == 1) System.out.println(1);
        else {
            int result = 1;
            while (true) {
                if(m <= (result * (result + 1)) / 2){
                    break;
                }
                result++;
            }
            System.out.println(result + 1);
        }

    }
}
