package LinkedList;

class Node {
    int data;
    Node next;

    Node() {}
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList() {}
    LinkedList(Node node){
        this.head = node;
    }

    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

    public void addData(int data){
        if(this.head ==null ){
            this.head = new Node(data,null);
        }else {
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data,null);
        }
    }

    public void removeData(){
        if(this.isEmpty()){
            System.out.println("리스트가 비었습니다");
            return;
        }
        Node cur = this.head; // 마지막 노드를 가르킬 부분
        Node prev = cur; // 마지막 전의 노드를 가르킬 부분
        while(cur.next != null) {
            prev = cur; 
            cur = cur.next;
        }
        if(cur == this.head){ // 만약 Node가 head노드였다, 그럼 그냥 head노드 삭제
            this.head = null;
        }else{
            prev.next = null; // 아니면 next 값을 삭제함, 자바는 가비지컬렉터가 있어서 알아서 제거해줌
        }
    }

    public void findData(int data){
        if(this.isEmpty()){
            System.out.println("비었습니다");
            return;
        }
        Node cur = this.head;
        while(cur.next != null){
            if(cur.data == data){
                System.out.println("데이터 발견:"+cur.data);
                return;
            }
            cur = cur.next;
        }
        System.out.println("데이터 발견 실패");
    }

    public void showData(){
        if(this.isEmpty()){
            System.out.println("비었습니다");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class Linked_list {
    public static void main(String[] args){

        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();      // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();      // 1 2 3 4 5

        myList.findData(3);     // Data exist!
        myList.findData(100);   // Data not found!

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();      // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData();    // List is empty
    }
}
