package Graph;// Practice1
// 인접 리스트를 이용한 그래프 구현

class Node {
    int id;
    Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}
class MyGraphList {
    char[] vertices;
    Node[] adjList;
    int elemCnt;

    MyGraphList(){}
    MyGraphList(int size){
        this.vertices = new char[size];
        this.adjList = new Node[size];
        this.elemCnt = 0;
    }

    public boolean isFull(){
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data){
        if(this.isFull()){
            System.out.println("그래프가 꽉 찼습니다");
            return;
        }
        this.vertices[elemCnt++] = data;
    }

    // 양방향
    public void addEdge(int x,int y){
        //서로 연결된 노드 2개를 삽입
        // 리스트를 순회하지 않고, 가장 앞단의 데이터를 갱신하는 형태로 구현
        this.adjList[x] = new Node(y, this.adjList[x]); // Vertex의 data와 다음 노드
        this.adjList[y] = new Node(x, this.adjList[y]);
    }
    // 단방향
    public void addDirectedEdge(int x,int y){
        this.adjList[x] = new Node(y, this.adjList[x]);
    }

    public void printAdjacentList(){
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i]+": ");

            Node cur = this.adjList[i];
            while(cur != null){
                System.out.print(this.vertices[cur.id]+" ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MyGraphList graph = new MyGraphList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentList();
    }
}
