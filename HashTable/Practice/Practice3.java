package HashTable.Practice;// Practice3
// 참고 - Hashtable? HashMap?
/*
    해쉬 테이블과 해쉬 맵의 차이
    공통점 : 둘 다 Map 인터페이스를 구현한 것
    차이점 : 키값으로 null을 사용할 수 있냐 없냐,
    차이점 : Thread-safe 측면에서 해쉬테이블은 안정, 맵은 안정 x
    테이블은 멀티쓰레드에서 우수, 맵은 싱글쓰레드에서 우수
    >> syncronizedMap, ConcurrentHashMap은 멀티쓰레드에서 가능
    >> lock 과 unlock을 통해서, 해쉬테이블에는 기본적으로 concurrency 문제가 해결되어있음
 */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Practice3 {
    public static void main(String[] args) {
        // 해쉬 테이블
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        ht.put(0,10);
        System.out.println(ht.get(0));

        // 해쉬 맵
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,10);
        System.out.println(map.get(0));
 
        // Map 에서 뻗어나온것이기 때문에 다형성으로 상속가능
        Map<Integer,Integer> map1 = ht;
        Map<Integer,Integer> map2 = map;
        System.out.println(map1.get(0));
        System.out.println(map2.get(0));

        // 차이점 ?
//        ht.put(null,-111);
//        System.out.println(ht.get(null)); // 테이블은 에러 발생

        // 해쉬 맵은 null 키 가능
        map.put(null,-111);
        System.out.println(map.get(null));

    }
}
