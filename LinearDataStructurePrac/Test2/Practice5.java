package LinearDataStructurePrac.Test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.stream.Stream;

public class Practice5 {
    public static ArrayList<Integer> solution(String[] gems) {
        //구매 가능한 모든구간을 넣을 리스트
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //젬의 종류를 중복제거해서 set에 저장
        HashSet<String> set = new HashSet<>();
        Stream.of(gems).forEach(x -> set.add(x));

        int n = set.size();
        //보석이 1종류면 바로 1,1 의 리스트 반환
        if(n == 1){
            result.add(new ArrayList<>(Arrays.asList(1,1)));
            return result.get(0);
        }

        //보석의 종류와 갯수를체크할 테이블 생성
        Hashtable<String,Integer> ht = new Hashtable<>();
        boolean isCandidate = false;

        // 왼쪽에서 끝까지가면서, 모든 보석의 종류와 갯수를 체크하고
        // right가 끝에 도달하면 left를 이동시키면서, 최소 진열대의 길이를 체크할것임
        int left = 0;
        int right= 0;

        //첫번째 보석은 넣고 시작
        ht.put(gems[0],1);

        while(true){
            // 우선 오른쪽으로 이동하면서, 카운팅 및 put
            if(!isCandidate){
                right += 1;
                //보석 배열 벗어나면 break;
                if(right >= gems.length){
                    break;
                }
                // 보석이 map에 없으면 put 있으면 카운트 증가
                if(!ht.containsKey(gems[right])){
                    ht.put(gems[right],1);
                }else{
                    ht.put(gems[right],ht.get(gems[right])+1);
                }

                //만약 맵에 모든 보석의 종류가 들어가면, true로 바꿔주고
                //해당 left부터 right범위에 리스트를 추가
                if(ht.size() == n){
                    isCandidate = true;
                    result.add(new ArrayList<>(Arrays.asList(left+1,right+1)));
                }
            }else{
                // 모든 보석이 들어간상태면 left를 이동시키면서
                //보석을 제거해보고 다시 range를 체크 
                left += 1;
                int cnt = ht.get(gems[left-1]) -1;

                if(cnt ==0){
                    ht.remove(gems[left-1]);
                    isCandidate = false;
                }else{
                    ht.put(gems[left-1],cnt);
                    result.add(new ArrayList<>(Arrays.asList(left+1,right+1)));
                }
            }
        }

        //최소 list 반환
        int minIdx = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> cur = result.get(i);
            left = cur.get(0);
            right = cur.get(1);

            if(right -left < minNum){
                minNum = right - left;
                minIdx = i;
            }
        }
        return result.get(minIdx);
    }

    public static void main(String[] args) {
        // Test code
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution(gems));

        gems = new String[]{"XYZ", "XYZ", "XYZ"};
        System.out.println(solution(gems));

        gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(solution(gems));
    }
}
