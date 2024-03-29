package Tree;// Practice2
// 연결 리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

//char 형 데이터를 담을 변수와 왼쪽 오른쪽 자식을 담을 노드 객체 생성
class Node {
    char data;
    Node left;
    Node right;

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    } 
}

class BinaryTree2 {
    Node head;

    BinaryTree2() { }
    BinaryTree2(char[] arr){
        Node[] nodes = new Node[arr.length];
        //우선 모든 노드에 데이터를 삽입해줌
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i],null,null);
        }
        // 자식노드의 인덱스를구해서, 연결해주는 작업
        for (int i = 0; i < arr.length; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if(left < arr.length){
                nodes[i].left = nodes[left];
            }
            if(right < arr.length){
                nodes[i].right = nodes[right];
            }
        }
        // root 노드 연결
        this.head = nodes[0];
    }

    public void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.data+" ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node node){
        if(node == null){
            return;
        }

        this.inOrder(node.left);
        System.out.print(node.data+" ");
        this.inOrder(node.right);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data+" ");
    }

    //큐를 이용해서 레벨오더 구현, 재귀함수와는 형태가 맞지 않음
    public void levelOrder(Node node){
        Queue<Node> que = new LinkedList<>();
        que.add(node);

        //큐에는 레벨순서대로 노드가 들어가고, 
        // 한개씩 pop하면서 데이터가 출력됨
        while(!que.isEmpty()){
            Node cur = que.poll();

            System.out.print(cur.data+" ");
            if(cur.left != null){
                que.add(cur.left);
            }
            if(cur.right != null){
                que.add(cur.right);
            }
        }
    }

}


public class Practice2 {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
