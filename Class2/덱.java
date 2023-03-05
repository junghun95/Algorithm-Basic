package algorithm.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str){
                case "push_front":{
                    int a = Integer.parseInt(st.nextToken());
                    stack.offerFirst(a);
                    break;
                }
                case "push_back":{
                    int a = Integer.parseInt(st.nextToken());
                    stack.offerLast(a);
                    break;
                }
                case "pop_front":{
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else sb.append(stack.pollFirst()).append("\n");
                    break;
                }
                case "pop_back":{
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else sb.append(stack.pollLast()).append("\n");
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
            }
        }
        System.out.println(sb);
    }
}
