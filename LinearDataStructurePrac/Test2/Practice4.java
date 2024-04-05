package LinearDataStructurePrac.Test2;

import java.util.HashMap;
import java.util.Hashtable;

public class Practice4 {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        // 완주한 사람의 이름을 맵에 넣고, 2명이라면 카운트를 증가시킴
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i],map.getOrDefault(completion[i],0)+1);
        }
        for (int i = 0; i < participant.length; i++) {
            // 완료자 명단에 포함되어있다면
            if(map.containsKey(participant[i])){ 
                //카운트가 이미 0이면 해당 경주자는 완주못한거
                if(map.get(participant[i]) == 0){
                    return participant[i];
                }
                //해당 참가자 명단의 카운트 감소
                map.put(participant[i],map.get(participant[i])-1);
            }else{ // 없으면 당연히 완주못함
                return participant[i];
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Test code
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
