package dequeue;// Practice1
// 데이터 재정렬
// D_0 -> D_1 -> ... -> D_n-1 -> D_n 순으로 되어 있는 데이터를
// D_0 -> D_n -> D_1 -> D_n-1 -> ... 순이 되도록 재정렬 하시오.

// 입력 예시)
// 입력 데이터: 1 -> 2 -> 3 -> 4 -> 5
// 출력 데이터: 1 -> 5 -> 2 -> 4 -> 3


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

public class Prac1 {
    public static void reorderData(int[] arr) {
        Deque deque = new ArrayDeque();
        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(x -> deque.addLast(x));
        System.out.println("정렬전");
        System.out.println(deque);
        while(!deque.isEmpty()){
            result.add(deque.removeFirst());
            if(!deque.isEmpty()){
                result.add(deque.removeLast());
            }
        }
        System.out.println("정렬후");
        for (int i = 0; i < result.size(); i++) {
            if(i == result.size() -1){
                System.out.print(result.get(i));
                break;
            }
            System.out.print(result.get(i)+" -> ");
        }
        //어레이로 인트리스트를 변환하는 방법
        //int[] arr2 = result.stream().mapToInt(x -> (int)x).toArray();
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr);   // 1 -> 5 -> 2 -> 4 -> 3

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2);  // 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4
    }
}
