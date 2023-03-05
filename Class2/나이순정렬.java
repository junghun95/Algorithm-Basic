package algorithm.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Person> pq = new PriorityQueue<Person>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Person p = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i);
            pq.add(p);
        }
        for (int i = 0; i < N; i++){
            Person p = pq.poll();
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.println(sb);
    }

    private static class Person implements Comparable<Person>{
        int age;
        String name;
        int uid;

        public Person(int age, String name, int uid){
            this.age = age;
            this.name = name;
            this.uid = uid;
        }

        @Override
        public int compareTo(Person o) {
            if(this.age < o.age) return -1;
            else if (this.age > o.age) return 1;
            else return this.uid - o.uid;
        }
    }
}
