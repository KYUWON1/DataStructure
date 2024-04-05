package PriorityQue;// 비선형 자료구조 - 우선순위 큐
// 연결 리스트를 이용한 우선순위 큐
// 자바 기본 PriorityQueue

import java.util.*;

public class Main {
    // 오름차순으로 데이터를 집어넣는 형태
    public static void enqueue(LinkedList<Integer> list, int data) {
        int idx = list.size();
        // 들어온 값의 자리를 찾아줌, 더큰값이 나오면, 해당 자리의 index반환
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > data){
                idx = i;
                break;
            }
        }
        list.add(idx,data); // 해당 인덱스에 삽입
    }

    //정렬되오있기 때문에 삭제는 그냥 앞에하면됨
    public static Integer dequeue(LinkedList<Integer> list) {
        if(list.isEmpty()){
            return null;
        }
        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args) {
        // 연결리스트를 이용한 우선순위 큐
        System.out.println("== 연결리스트 방식의 우선순위 큐 ==");
        LinkedList<Integer> pqList = new LinkedList();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 9);
        System.out.println(pqList);

        System.out.println(dequeue(pqList));
        System.out.println(dequeue(pqList));
        System.out.println(pqList);
        System.out.println();

        // 자바 기본 PriorityQueue 사용
        System.out.println("== 자바 기본 우선순위 큐 ==");
        // 우선순위: 낮은 숫자 순
        // 힙을 사용해서 구현하기 때문에 출력 형태가 약간 다름
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(1);
        pq.add(2);
        System.out.println(pq);



        // 우선순위: 높은 숫자 순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(5);
        pq2.add(7);
        pq2.add(3);
        pq2.add(1);
        pq2.add(2);
        System.out.println(Arrays.toString(pq2.toArray()));

    }
}
