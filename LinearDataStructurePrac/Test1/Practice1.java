package LinearDataStructurePrac.Test1;

import java.util.Arrays;

public class Practice1 {

    public static int[] solution(int[] arr){
        int[] arrNew = new int[arr.length];

        int idx = 0 ;
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr.length; j++) {
                //데이터를 넣을부분을 찾음
                if(arrNew[idx] == 0){
                    break;
                }
                //만약 빈공간을 찾지 못하면 하나씩 이동
                idx = (idx + 1) % arr.length;
            }
            //알맞은 인덱스 위치에 arr의 데이터를 0부터 대입
            arrNew[idx] = arr[i];
            idx = (idx + arr[i]) % arr.length;
        }

        return arrNew;
    }

    public static int[] modification(int[] arr) {
        int[] arrNew = new int[arr.length];

        int idx = 0;
        int cnt = 0;
        int val = arr[idx];

        while (cnt < arr.length) {
            while (val == 0) {
                // val에 값이 들어감
                idx = (idx + 1) % arr.length;
                val = arr[idx];
            }
            //새로운 배열 에 val을 넣고 Cnt증가
            arrNew[cnt++] = val;
            arr[idx] = 0; // 해당 값은 0으로 초기화 이제 여긴안걸림
            // idx에 해당 val값 더함 
            idx = (val + idx) % arr.length;
            // val은 해당 인덱스
            val = arr[idx];
        }
        return arrNew;
    }


    public static void main(String[] args) {
        // Test code
        // Modification test
        int[] arr = {1, 3, 7, 9, 5};
        int[] arrNew = modification(arr);
        System.out.println(Arrays.toString(arrNew));

        // Revert data
        arr = new int[]{1, 3, 5, 7, 9};
        int[] arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));

        arr = new int[]{3, 2, 6, 8};
        arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));
    }
}
