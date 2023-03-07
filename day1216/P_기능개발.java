package day1216;
import java.util.*;

public class P_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        int cur = 0;
//        Queue<Integer> pro = new LinkedList<>();
//        for(int progress : progresses) pro.add(progress);
//        Queue<Integer> spe = new LinkedList<>();
//        for(int speed : speeds) spe.add(speed);
//
//        while(true){
//            Integer progress = pro.poll();
//            Integer speed = spe.poll();
//
//            if(progress + cur * speed >= 100){
//                cnt++;
//                if(pro.isEmpty()){
//                    list.add(cnt);
//                    break;
//                }
//                continue;
//            } else {
//                if(cnt != 0){
//                    list.add(cnt);
//                    cnt = 0;
//                }
//                if((100 - progress) % speed == 0){
//                    cur += ((100 - progress) / speed);
//                } else {
//                    cur += ((100 - progress) / speed) + 1;
//                }
//                cnt++;
//                if(pro.isEmpty()){
//                    list.add(cnt);
//                    break;
//                }
//            }
//        }
        loop:
        for(int i = 0; i <= 100; i++){
            if(progresses[cur] + speeds[cur] * i < 100){
                if(cnt != 0){
                    list.add(cnt);
                    cnt = 0;
                }
                continue;
            } else {
                while(progresses[cur] + speeds[cur] * i >= 100){
                    cur++;
                    cnt++;
                    if(cur == progresses.length){
                        list.add(cnt);
                        break loop;
                    }
                }
                list.add(cnt);
                cnt = 0;

            }
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }
//        System.out.println(answer.toString());
    }
}
