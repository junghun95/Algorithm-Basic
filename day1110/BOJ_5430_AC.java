package day1110;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_5430_AC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        loop:
        for (int i = 0; i < T; i++){
            String p = sc.next();
            int n = sc.nextInt();
            String str = sc.next();
            str = str.substring(1,str.length() - 1);
            String[] strs = str.split(",");

            ArrayList<Integer> list = new ArrayList<>();
            if(n == 0){
                for (int j = 0; j < p.length(); j++){
                    if (p.charAt(j) == 'D'){
                        System.out.println("error");
                        continue loop;
                    }
                }
                System.out.println("[]");
                continue;
            }
            for(int j = 0; j < strs.length; j++){
                list.add(Integer.parseInt(strs[j]));
            }
            boolean dir = false; // 앞방향
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) == 'R'){
                    dir = !dir;
                } else {
                    if(list.isEmpty()){
                        System.out.println("error");
                        break;
                    }
                    if(dir){
                        list.remove(list.size() - 1);
                        n--;
                    } else {
                        list.remove(0);
                        n--;
                    }
                }
            }
            if (dir){
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < list.size(); j++){
                    temp.add(list.get(list.size() - j - 1));
                }
                System.out.println(temp.toString());
            }else {
                System.out.println(list.toString());
            }
        }
    }
}
