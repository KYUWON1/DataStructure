package LinearDataStructurePrac.Test2;


import java.util.LinkedList;
import java.util.Queue;

class Print {
    int idx;
    int prior;

    public Print(int idx, int prior) {
        this.idx = idx;
        this.prior = prior;
    }
}

public class Practice1 {
    public static void solution(int docs, int target, int[] priority) {
        Queue<Print> que = new LinkedList<>();
        for (int i = 0; i < docs; i++) {
            que.add(new Print(i,priority[i])); // que에 인덱스와 중요도 를 담은 구조체너흥ㅁ
        }
        
        int cnt = 1; //출력횟수
        while(true){
            //우선 하나를 뽑아온다
            Print cur = que.poll();

            //여기가 좀 어려움
            // 해당 cur 문서보다 우선순위가 높은 문서를확인하기 위해 배열 형태로 가져와서 길이를 체크함
            Print[] arr = que.stream().filter(x -> x.prior > cur.prior).toArray(Print[]::new);
            if(arr.length >0){ // 우선순위 높은게 있다면
                que.add(cur);
            }else{
                // 타    겟의 인덱스와 같으면 출력하고
                if(cur.idx == target){
                    System.out.println(cnt);
                    break;
                }else{ //아니면 뽑긴했으니까 cnt증가
                    cnt++;
                }
            }
        }



    }

    public static void main(String[] args) {
        // Test code
        int docs = 1;
        int target = 0;
        int[] priority = {5};
        solution(docs, target, priority);

        docs = 4;
        target = 2;
        priority = new int[]{1, 2, 3, 4};
        solution(docs, target, priority);

        docs = 6;
        target = 0;
        priority = new int[]{1, 1, 9, 1, 1, 1};
        solution(docs, target, priority);
    }
}
