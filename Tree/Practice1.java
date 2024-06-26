package Tree;// Practice1
// 배열을 이용한 이진 트리 구성, 순회

class BinaryTree {
    char[] arr;

    BinaryTree(char[] data){
        this.arr = data;
    }

    // 재귀 함수로 구현한 preorder 탐색, 현재 왼쪽 오른쪽
    public void preOrder(int idx){
        System.out.print(this.arr[idx]+" ");

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if(left < this.arr.length){
            this.preOrder(left);
        }

        if(right < this.arr.length){
            this.preOrder(right);
        }
    }

    //왼쪽 현재 오른쪽
    public void inOrder(int idx){
        int left = 2 * idx +1;
        int right = 2 * idx + 2;

        if(left < this.arr.length){
            this.inOrder(left);
        }
        System.out.print(this.arr[idx]+" ");
        if(right < this.arr.length){
            this.inOrder(right);
        }
    }

    //왼쪽 오른쪽 현재
    public void postOrder(int idx){
        int left = 2 * idx +1;
        int right = 2 * idx + 2;

        if(left < this.arr.length){
            this.preOrder(left);
        }

        if(right < this.arr.length){
            this.preOrder(right);
        }

        System.out.print(this.arr[idx]+" ");
    }

    //위쪽부터 왼쪽부터 오른쪽으로 출력
    public void levelOrder(int idx){
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0);
        System.out.println();
    }
}
