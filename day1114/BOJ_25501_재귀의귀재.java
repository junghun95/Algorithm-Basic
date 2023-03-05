package day1114;

import java.util.Scanner;

public class BOJ_25501_재귀의귀재 {
    static int cnt;
    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < T; i++){
            String str = sc.nextLine();
            cnt = 0;
            System.out.println(isPalindrome(str) + " " + cnt);
        }
    }
}
