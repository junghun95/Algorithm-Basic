package algorithm.Class2;

import java.util.Scanner;

public class 최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        // a가 b보다 크게 설정
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 최대공약수
        int max = 0;
        for (int i = 1; i <= b; i++){
            if(a % i == 0 && b % i == 0){
                max = i;
            }
        }

        // 최소공배수
        int min = 0;
        int prod = 1;
        while (true) {
            if ((a * prod) % b == 0) {
                min = a * prod;
                break;
            }
            prod++;
        }
        System.out.println(max);
        System.out.println(min);
    }
}
