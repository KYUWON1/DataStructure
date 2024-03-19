package Queue;// 선형 자료구조 - 큐


import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //Queue 로 생성하지 않는 이유는 Queue는 인터페이스로 구현되어있기 때문에
        //구현해야할 메소드가 상당히 많음, 해서 링크리스트에 이미 Queue에서 사용하는
        //함수들이 많이 구현되어있기 때문에, 다형성을 이용해서 que를 생성.
        Queue que = new LinkedList();

        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        System.out.println(que);

        System.out.println(que.poll());
        System.out.println(que);

        System.out.println(que.poll());
        System.out.println(que);

        System.out.println(que.peek());
        System.out.println(que);

        System.out.println(que.contains(3));
        System.out.println(que.size());
        System.out.println(que.isEmpty());

        que.clear();
        System.out.println(que);
        System.out.println(que.poll()); // 큐에서는 예외처리말고 null을 반환해줌
    }
}
