package algorithm.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str){
                case "push":{
                    int a = Integer.parseInt(st.nextToken());
                    stack.offer(a);
                    break;
                }
                case "pop":{
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else sb.append(stack.pop()).append("\n");
                    break;
                }
                case "front":{
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else sb.append(stack.peekFirst()).append("\n");
                    break;
                }
                case "back":{
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else sb.append(stack.peekLast()).append("\n");
                    break;
                }
                case "size":{
                    sb.append(stack.size()).append("\n");
                    break;
                }
                case "empty":{
                    if (stack.isEmpty()){
                        sb.append(1).append("\n");
                    }else sb.append(0).append("\n");
                    break;
                }
                case "top":{
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
