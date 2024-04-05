package PriorityQue.Prac;// Practice1
// nums 배열에 주어진 정수들 중에서 k 번째로 큰 수를 반환한는 프로그램을 작성하세요.

// 입력 예시
// 입력: 3, 1, 2, 7, 6, 4
// k: 2
// 출력: 6

// 입력: 1, 3, 7, 4, 2, 8, 9
// k: 7
// 출력: 1

// 정렬을 통해 접근해도되지만, 우선순위 큐도로 구현가능


import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice1 {
    public static int solution1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //자리바꿈은 알아서 일어나서 신경쓰지 않아도됨
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);

            // size k보다 커지면 계속 poll()해서 유지
            if(pq.size() >k){
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static int solution2(int[] nums, int k) {
        Arrays.sort(nums); // 정렬하고

        return nums[nums.length -k ];
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {3, 1, 2, 7, 6, 4};
        System.out.println(solution1(nums, 2));
        System.out.println(solution2(nums, 2));
        System.out.println();

        nums = new int[]{1, 3, 7, 4, 2, 8, 9};
        System.out.println(solution1(nums, 7));
        System.out.println(solution2(nums, 7));
    }
}
