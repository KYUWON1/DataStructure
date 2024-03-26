package LinkedList;// Practice1
// 단순 연결 리스트 구현 완성

//기존에 만든 연결리스트에 추가 구현
class LinkedList2 extends LinkedList{

    LinkedList2(Node node){
        this.head = node;
    }

    // 중간에 데이터 추가
    public void addData(int data,Integer beforeData){
        if(this.head == null){ // 헤드가 비었을때
            this.head = new Node(data,null);
        }else if(beforeData == null){ // beforedata에 아무 값도 넣지 않았을때
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data,null);
        }else{ // beforedata를 가진 노드 앞에 대입
            Node cur = this.head;
            Node pre = cur;
            while(cur != null){
                if(cur.data == beforeData){
                    if(cur == this.head){
                        this.head = new Node(data,this.head);
                    }else{
                        pre.next = new Node(data,cur);
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    //데이터에 해당하는 노드를 지우는데, 연결이 끊기지 않도록
    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("비었습니다");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while(cur != null){
            if(cur.data == data){
                if(cur == this.head){
                    this.head = cur.next; // 헤드를 다음 값으로 변경
                }else{
                    pre.next = cur.next; // 이전의 next를 cur의 next로 변경해서 cur.data는 없어짐
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}

public class Practice1 {
    public static void main(String[] args) {

//      Test code
        LinkedList2 myList = new LinkedList2(new Node(1, null));
        myList.showData();         // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();         // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();         // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();         // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();         // List is empty!
    }
}
