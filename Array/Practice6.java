package Array;// Practice6
// 배열 arr 에서 중복 값을 제거한 새 배열을 만드시오.

// 입출력 예시)
// arr: 1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5
// 결과: 1, 5, 3, 2, 4

import java.util.Arrays;

public class Practice6 {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,2,3,1,4,1,2,3,5};
        int[] newArr = new int[arr.length];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isContain = false;
            for (int j = 0; j < idx; j++) {
                if(arr[i] == newArr[j]){ // 배열에 포합되어있다면
                    isContain = true;
                }
            }
            if(!isContain){
                newArr[idx++] = arr[i];
            }
        }
        for (int i = 0; i < idx; i++) {
            System.out.print(newArr[i]+" ");
        }
    }
}
