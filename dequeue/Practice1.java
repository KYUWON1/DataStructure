package dequeue;// Practice1
// ArrayList 를 이용한 데크 구현

import java.util.ArrayList;

class MyDeque1 {
    ArrayList list;

    MyDeque1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void addFirst(int data) {
        this.list.add(0,data); // 첫번째 자리에 삽입
    }

    public void addLast(int data) {
        this.list.add(data);
    }

    public Integer removeFirst() {
        if(this.list.isEmpty()){
            return null;
        }
        return (int)this.list.remove(0);
    }

    public Integer removeLast() {
        if(this.list.isEmpty()){
            return null;
        }
        return (int)this.list.remove(this.list.size()-1);
    }

    public void printDeque() {
        System.out.println(this.list);
    }

}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MyDeque1 myDeque = new MyDeque1();
        // Front 부분 입력
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);
        myDeque.printDeque();    // 3 2 1

        // Rear 부분 입력
        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addLast(30);
        myDeque.printDeque();    // 3 2 1 10 20 30

        // Front 부분 출력
        System.out.println(myDeque.removeFirst());  // 3
        myDeque.printDeque();    // 2 1 10 20 30

        // Rear 부분 출력
        System.out.println(myDeque.removeLast());   // 30
        myDeque.printDeque();    // 2 1 10 20

        System.out.println(myDeque.removeLast());   // 20
        System.out.println(myDeque.removeLast());   // 10
        System.out.println(myDeque.removeLast());   // 1
        System.out.println(myDeque.removeLast());   // 2
        myDeque.printDeque();
    }
}
