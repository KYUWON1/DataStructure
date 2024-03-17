package Array;// 선형 자료구조 - 배열

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//      1차원 배열
        System.out.println("== 1차원 배열 ==");
        int[] arr = {1, 2, 3, 4, 5};
        for (int item: arr) {
            System.out.println("item = " + item);
        }

        arr[1] = 100;
        System.out.println("arr = " + arr);


//      2차원 배열
        System.out.println("== 2차원 배열 ==");
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(arr2[0][1]);

        for(int[] row: arr2) {
            for(int item: row) {
                System.out.println("item = " + item);
            }
        }


//      ArrayList - 1차원, 2차원
        System.out.println("== ArrayList ==");
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3)); // 어레이를 리스트로 생성
        System.out.println("list1 = " + list1);
        list1.add(4); //어레이리스트에 추가
        list1.add(5);
        System.out.println("list1 = " + list1);
        list1.remove(2); //인덱스 2의 값 제거
        System.out.println("list1 = " + list1);
        list1.remove(Integer.valueOf(2)); // 리스트안에 값이 2인 인덱스를 제거 
        System.out.println("list1 = " + list1);

        ArrayList list2d = new ArrayList(); //2차원 배열처럼 생성됨
        ArrayList list1d1 = new ArrayList(Arrays.asList(1, 2, 3));
        ArrayList list1d2 = new ArrayList(Arrays.asList(4, 5, 6));
        list2d.add(list1d1);
        list2d.add(list1d2);
        System.out.println("list1d1 = " + list1d1);
        System.out.println("list1d2 = " + list1d2);
        System.out.println("list2d = " + list2d);
    }
}
