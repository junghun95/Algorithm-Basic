package day0112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1873_스택수열 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int N = sc.nextInt();
        int N = Integer.parseInt(br.readLine());
        int[] targetArray = new int[N];
        for(int i = 0; i < targetArray.length; i++){
            targetArray[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();

        int i = 1;
        int pos = 0;
        int target = targetArray[pos];
        while (true){
            // push할때 i++

            // i가 target보다 작으면 같을때까지 push하고 마지막에 pop
            if(i < target){
                stack.push(i);
                sb.append("+").append("\n");
//                System.out.println("+");
                i++;
            }
            // i가 target이랑 같으면 push하고 pop
            else if(i == target) {
                stack.push(i);
                sb.append("+").append("\n");
//                System.out.println("+");
                i++;
                stack.pop();
                sb.append("-").append("\n");
//                System.out.println("-");
//                System.out.println("i : " + i + " ,target : " + target);
                target = targetArray[++pos];
            }
            // i가 target보다 크면 pop해서 같으면 pop 다르면 NO
            else {
                int temp = stack.pop();
//                System.out.println(temp);
                if(temp == target){
                    sb.append("-").append("\n");
//                    System.out.println("-");
//                    System.out.println("i : " + i + " ,target : " + target);
                    if(pos < N - 1){
                        target = targetArray[++pos];
                    }
                } else {
//                    System.out.println("i : " + i + " ,target : " + target + " , temp : " + temp);
                    sb.delete(0,sb.length());
                    sb.append("NO");
//                    System.out.println("NO");
                    break;
                }
            }
            if(pos == N - 1) {
                sb.append("-").append("\n");
//                System.out.println("-");
                break;
            }
        }
        System.out.println(sb.toString());
//        sc.close();
    }
}
