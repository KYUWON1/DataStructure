package LinkedListPractice;// Practice3
// 연결 리스트 부분 뒤집기
// 주어진 연결 리스트에서 시작 위치부터 끝 위치 사이의 노드들을 뒤집으시오.

// 입력 예시)
// 입력 연결 리스트: 1, 2, 3, 4, 5
// 시작 위치: 2
// 끝 위치: 4
// (처음 위치는 1부터라고 가정)
// 결과 연결 리스트: 1, 4, 3, 2, 5


public class Practice3 {
    public static LinkedList reverseList(LinkedList list, int left, int right) {
        Node cur1 = null;
        Node pre1 = null;

        // cur1은 left를 가르킬 노드, pre1은 left 전의 노드 
        cur1 = list.head;
        for (int i = 1; i < left; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        Node cur2 = cur1;
        Node pre2 = pre1;
        Node after = null;
        
        // Node 스왑과정 pre1와 cur1은 내비두고, cur2와 pre2를 사용해서 순회
        for (int i = left; i <= right ; i++) {
            //다음 노드의 위치를 저장함
            after = cur2.next;
            // left노드의 next를 그전 노드로 변경
            cur2.next = pre2;
            // cur2.next 노드를 cur2로 변경
            pre2 = cur2;
            //cur2는 after로 변경
            cur2 = after;
        }

        //마지막에 저장해두었던 cur1와 pre1의 next 노드 변경
        pre1.next = pre2;
        cur1.next = cur2;

        return list;
    }
    
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        linkedList.addData(4);
        linkedList.addData(5);
        linkedList.showData();

        linkedList = reverseList(linkedList, 2, 4);
        linkedList.showData();


        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(1);
        linkedList2.addData(2);
        linkedList2.addData(3);
        linkedList2.addData(4);
        linkedList2.addData(5);
        linkedList2.addData(6);
        linkedList2.addData(7);
        linkedList2.showData();

        linkedList2 = reverseList(linkedList2, 3, 5);
        linkedList2.showData();

    }
}
