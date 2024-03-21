package HashMap;

import java.util.HashMap;

public class Main {

    static class Test {
        int a;
        Test(int n){
            this.a = n;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        map.put("사과",3000);
        map.put("바나나",5000);
        map.put("망고",10000);
        System.out.println(map);

        System.out.println(map.get("사과"));
        //없을시 디폴트 값 반환
        System.out.println(map.getOrDefault("없다",0));

        System.out.println(map.remove("사과"));
        System.out.println(map);

        //출력값이 정렬되어있지 않음
        for(String key:map.keySet()){
            System.out.print(key+" ");
        }
        System.out.println();
        for(int n : map.values()){
            System.out.print(n+" ");
        }
        System.out.println();
        map.put("망고", 15000);
        System.out.println(map);

        //객체는 같아도 주소값이 다르기 때문에 중복으로 사용가능하다.
        HashMap<Test,Integer> map2 = new HashMap<>();
        map2.put(new Test(1),1);
        map2.put(new Test(1),5);
        System.out.println(map2);
    }
}
