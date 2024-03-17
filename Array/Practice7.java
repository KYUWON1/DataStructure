package Array;// Practice7
// 2차원 배열 arr 을 시계방향 90도 회전시킨 결과를 출력하세요.

// 입출력 예시:
// arr:
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15
// 결과:
// 11 6 1
// 12 7 2
// 13 8 3
// 14 9 4
// 15 10 5


import java.util.Arrays;

public class Practice7 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5,},{6,7,8,9,10},{11,12,13,14,15}};
        int[][] newArr = new int[arr[0].length][arr.length]; //5바이 3
        int rowEnd = arr.length-1; //2
        int colEnd = arr[0].length-1; // 4

        for (int i = rowEnd; i >=0 ; i--) { // 2 1 0
            for (int j = 0; j <= colEnd; j++) { // 0 1 2 3 4
                newArr[j][rowEnd-i] = arr[i][j];
            }
        }

        for(int[] a: newArr){
            for(int n :a){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
}
