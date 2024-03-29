package Tree;// Practice3

import java.util.LinkedList;
import java.util.Queue;

// 트리 구조 복습 / 구현
class Node2{
    char data;
    Node2 left;
    Node2 right;
    Node2 parent;

    public Node2(char data, Node2 left, Node2 right, Node2 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class BinaryTree3 {
    Node2 head;

    BinaryTree3(char[] arr){
        Node2[] nodes = new Node2[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node2(arr[i],null,null,null);
        }
        for (int i = 0; i < arr.length; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if(left <arr.length){
                nodes[i].left = nodes[left];
                //부모와도 연결
                nodes[left].parent = nodes[i];
            }

            if(right <arr.length){
                nodes[i].right = nodes[right];
                //부모와도 연결
                nodes[left].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Node2 searchNode(char data){
        Queue<Node2> que = new LinkedList<>();
        que.add(this.head);
        while(!que.isEmpty()){
            Node2 cur = que.poll();
            if(cur.data == data){
                return cur;
            }
            if(cur.left != null){
                que.add(cur.left);
            }
            if(cur.right != null){
                que.add(cur.right);
            }
        }
        return null;
    }

    public Integer checkSize(char data){
        Node2 node = this.searchNode(data);
        Queue<Node2> que = new LinkedList<>();
        que.add(node);
        int size = 0;
        while(!que.isEmpty()){
            Node2 cur = que.poll();
            if(cur.left != null){
                que.add(cur.left);
                size++;
            }
            if(cur.right != null){
                que.add(cur.right);
                size++;
            }
        }
        return size+1;
    }
}

public class Practice3 {

    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);

        // Root node
        System.out.println("Root: " + bt.head.data);

        // B's child node
        Node2 B = bt.searchNode('B');
        if(B.left != null){
            System.out.println("B -> left:"+B.left.data);
        }
        if(B.right != null){
            System.out.println("B -> right:"+B.right.data);
        }

        // F's parent node
        Node2 F = bt.searchNode('F');
        System.out.println("F -> Parents:"+F.parent.data);

        // Leaf node, 자식노드가 없는 노드들
        System.out.print("Lead node: ");
        for (int i = 0; i < arr.length; i++) {
            Node2 cur = bt.searchNode(arr[i]);
            if(cur.left ==null && cur.right ==null){
                System.out.print(cur.data +" ");
            }
        }


        // E's Depth
        Node2 E = bt.searchNode('E');
        Node2 cur = E;
        int depth = 0;
        while(cur.parent != null){
            cur = cur.parent;
            depth++;
        }
        System.out.println("E depth:"+depth);


        // Level2 Node
        System.out.print("Level2 Node: ");
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt.searchNode(arr[i]);
            cur = target;
            int cnt = 0;
            while(cur.parent != null){
                cur = cur.parent;
                cnt++;
            }
            if(cnt == 2){
                System.out.print(target.data);
            }
        }
        System.out.println();

        // Height
        Node2 head = bt.head;
        int heigt = 0;
        while(head.left != null){
            head = head.left;
            heigt++;
        }
        System.out.println("height: "+heigt);

        // B's Size
        int size = bt.checkSize('B');
        System.out.println("B size: "+size);

    }
}
