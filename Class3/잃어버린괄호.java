package algorithm.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Integer> number = new LinkedList<>();
        LinkedList<Boolean> sign = new LinkedList<>();
        String num = "";
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '+'){
                if(!num.equals("")){
                    number.add(Integer.parseInt(num));
                    num = "";
                }
                sign.add(true);
            } else if (str.charAt(i) == '-') {
                if(!num.equals("")){
                    number.add(Integer.parseInt(num));
                    num = "";
                }
                sign.add(false);
            } else {
                num += String.valueOf(str.charAt(i));
            }
        }
        if(!num.equals("")){
            number.add(Integer.parseInt(num));
        }
        int answer = number.get(0);
        boolean flag = false;
        for (int i = 0; i < sign.size(); i++){
            if (sign.get(i) && !flag){ // +일때이고 flag가 false일때
                answer += number.get(i+1);
            } else if (sign.get(i) && flag) { // +이고 flag가 true일때 (앞에 -가 있었을때)
                answer -= number.get(i+1);
            } else if (!sign.get(i) && !flag) { // -이고 flag가 false일때
                answer -= number.get(i+1);
                flag = true;
            } else { // -이고 flag가 true일때
                answer -= number.get(i+1);
            }
        }
        System.out.println(answer);

    }
}
