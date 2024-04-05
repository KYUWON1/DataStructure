package PriorityQue;// Practice 1
// 자바 기본 PriorityQueue 응용
// 나이 순으로 오름차순 또는 내림차순 출력

import java.util.PriorityQueue;

class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        //1이 리턴이되면 변경을 안함
        //-1이 리턴이되면 변경을 실시함

        //새롭게 추가하는 데이터가 더 작을때 변경
        //this.age가 들어오는데이터, o.age가 기존데이터 
        return this.age >= o.age ? 1 : -1;
        //return this.age >= o.age ? -1 : 1; 내림차순
    }
}

public class Practice1 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person> pq = new PriorityQueue<>();

        //그냥 객체를 pq에 넣으면 에러가 발생함 why?
        //객체에 여러개의 변수가 있는데, 어떤 값을 우선순위로 결정할지 모르기때문에
        //따라서 compareto를 오버라이드 해주어야함 
        for (int i = 0; i < name.length; i++) {
            Person person = new Person(name[i],age[i]);
            pq.offer(person);
        }
        System.out.println("== 실제 출력 순서 ==");
        while(!pq.isEmpty()){
            Person p = pq.poll();
            System.out.println(p.name+" "+p.age);
        }

    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

        //람다함수를 통해, 내림차순으로 정렬되도록 사전에 세팅가능
        PriorityQueue<Person> pq2 = new PriorityQueue<>((Person p1, Person p2) ->
                p1.age >= p2.age ? -1 : 1);

        for (int i = 0; i < name.length; i++) {
            Person person = new Person(name[i],age[i]);
            pq2.offer(person);
        }
        System.out.println("== 실제 출력 순서 ==");
        while(!pq2.isEmpty()){
            Person p = pq2.poll();
            System.out.println(p.name+" "+p.age);
        }

    }
}
