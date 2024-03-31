package Graph.Practice;// Practice3
// 주어진 그래프를 두 개의 그래프로 분리할 수 있는지 확인 하는 프로그램을 작성하세요.
// 분리 조건: 인접하지 않은 노드끼리 분리

// 모든 노드는 연결되어 있다.
// 분리 가능하면 true, 불가능하면 false 출력

// 예시 입력)
// 0번 노드의 연결된 1,3번 1번노드에 연결된 0 2 번이라는 정보의 데이터임
// 그래프: {{1, 3}, {0, 2}, {1, 3}, {0, 2}}
// 출력: true

// 그래프: {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}
// 출력: false

public class Practice3 {
    public static void solution(int[][] graph) {
        // 노드의 개수만큼 flag 1, -1 을 체크할 flag배열추가
        int[] flags = new int[graph.length];

        // checkSplit에 그래프와 flags 정보, 최초로 1과 0 을 넘겨줌
        if(checkSplit(graph,flags,1,0) == true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        
    }

    //checkSplit에서는 들어온 graph와 flags에 값을 처리함
    public static boolean checkSplit(int[][] graph,int[] flags,int flag,int node){
        // 0이 아니라면, 이미 해당 노드에 와서 체크를 했다는 것인데
        // 그 다음 가려고하는 노드의 flag와 지금 flag와 일치한다면,
        // 즉 1, -1, 1 이런식으로 되어있다면 true, 아니면 false를 반환
        if(flags[node] != 0 ){
            return flags[node] == flag;
        }

        // flag는 1과 -1을 번갈아 가며 들어온다
        flags[node] = flag;
        // node에 인접한 노드에가서, 현재 node의 flag의 반대값을 넣어 체크한다
        for (int adjacentNode : graph[node]){
            // 인접 노드에 반대 flag를 넣는데 false가 나온다면
            // 즉, -1 , -1 ,-1 이렇게 규칙이 깨진다면 끝
            if(!checkSplit(graph,flags,-flag,adjacentNode)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        solution(graph);

        graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        solution(graph);
    }
}
