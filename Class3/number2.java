package algorithm.Class3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class number2 {
    public static void main(String[] args) {
        String[] companies = new String[]{"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
        String[] applicants = new String[]{"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
        String[] a = solution(companies, applicants);
        for (String str : a){
            System.out.println(str);
        }
    }
    public static String[] solution(String[] companies, String[] applicants) {
        String[] answer = {};

        // 회사 객체에 저장
        Company[] c = new Company[companies.length];
        for (int i = 0; i < companies.length; i++){
            String[] str = companies[i].split(" ");
            PriorityQueue<String> q = new PriorityQueue<>(((o1, o2) -> {
                String order = str[1];
                return order.indexOf(o2) - order.indexOf(o1);
            }));
            c[i] = new Company(str[0], str[1], Integer.parseInt(str[2]), q);
        }

        // 지원자 객체에 저장
        Applicant[] a = new Applicant[applicants.length];
        for (int i = 0; i < applicants.length; i++){
            String[] str = applicants[i].split(" ");
            a[i] = new Applicant(str[0], str[1], Integer.parseInt(str[2]), new boolean[companies.length], false);
        }

        // 처음한번 모두 1순위에 지원한 후에 반복문 돌리기
        for (int i = 0; i < a.length; i++){
            c[a[i].order.charAt(0) - 'A'].q.offer(a[i].name);
        }
        // 각 회사의 큐에서 사이즈 넘는건 reject에 넣기


        // 모든 지원자가 done상태가 true일때 까지 반복문 돌면서 체크(reject에 있는걸 다시 큐에 넣으면서ㅏ 돌기)
//        while (true){
//            for (int i = 0; i < a.length; i++){
//                a[]
//            }
//        }


        // 결과 출력
        for (int i = 0; i < companies.length; i++){
            Company company = c[i];
            StringBuilder sb = new StringBuilder();
            sb.append(company.name + "_");
            String[] result = new String[company.size];
            for (int j = 0; j < company.size; j++){
                result[j] = company.q.poll();
            }
            Arrays.sort(result);
            for (int j = 0; j < result.length; j++){
                sb.append(result[j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    public static class Company{
        String name;
        String order;
        int size;
        PriorityQueue<String> q;
        public Company(String name, String order, int size, PriorityQueue<String> q){
            this.name = name;
            this.order = order;
            this.size = size;
            this.q = q;
        }
    }

    private static class Applicant {
        String name;
        String order;
        int size;
        boolean[] done;
        boolean finish;
        public Applicant(String name, String order, int size, boolean[] done, boolean finish){
            this.name = name;
            this.order = order;
            this.size = size;
            this.done = done;
            this.finish = finish;
        }
    }
}
