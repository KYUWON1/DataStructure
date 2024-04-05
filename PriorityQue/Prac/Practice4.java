package PriorityQue.Prac;// Practice4
// 문자열 s 가 주어졌을 때, 문자열 내에 동일한 알파벳이 연속적으로 배치되지 않도록 재배치 하세요.
// 재배치가 가능한 경우 재정렬한 문자열을 반환하고 불가능한 경우 null 을 반환하세요.

// 입출력 예시
// 입력: "aabb"
// 출력: "abab"

// 입력: "aaca"
// 출력: null

//

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice4 {
    public static String solution(String s) {
        //맵에 빈도수별로 내림 차순으로 큐에 삽입
        HashMap<String,Integer> map = new HashMap<>();
        for(String item:s.split("")){
            map.put(item,map.getOrDefault(item,0)+1);
        }

        PriorityQueue<Map .Entry<String,Integer>> pq =
                new PriorityQueue<>((x,y) -> y.getValue() - x.getValue());

        for(Map.Entry<String,Integer> item: map.entrySet()){
            pq.offer(item);
        }

        StringBuffer sb = new StringBuffer();
        Map.Entry<String,Integer> prev = null;

        /*
        pq에서 노드를 가져오고 스트링버퍼에 추가한뒤 카운트를 하나 낮춘다,
        만약 count가 1이상 이라면 prev에 추가한뒤, 다음 노드를 가져온다
        다음노드의 값을 다시 추가하고 카운트를 하나 낮춘뒤, 만약 prev가 1이상이라면
        다시 que에 추가해준다, 그럼 큐가 순환이되면서 하나씩 버퍼에 추가될것이고
        연속적으로 같은 숫자를 추가하려고할때, null을 반환하게 된다
         */
        while(!pq.isEmpty()){
            Map.Entry<String,Integer> cur = pq.poll();

            if(prev != null && prev.getValue() > 0){
                pq.offer(prev);
            }

            sb.append(cur.getKey());
            cur.setValue(cur.getValue()-1);

            prev = cur;
            if(pq.isEmpty() && prev.getValue() > 0){
                return null;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("aabb"));
        System.out.println(solution("aaaaabccd"));
        System.out.println(solution("aaca"));
    }
}
