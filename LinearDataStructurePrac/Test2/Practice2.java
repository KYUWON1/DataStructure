package LinearDataStructurePrac.Test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Practice2 {
    public static void solution(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        int idx = 0; //stack에 넣을 숫자를 카운팅할 idx
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            //가져온 num이 현재 스택에 상태보다 크다면, 해당 숫자까지 스택에 넣어주고,
            // idx 를 해당 값으로 교체
            if(num > idx){
                for (int j = idx+1; j < num+1; j++) {
                    stack.push(j);
                    result.add("+");
                }
                idx = num;
            //가져온 num이 스택의 맨위의 값과 다르다면, NO 출력하고 끝 , 같으면 pop!하겟지
            //작은값이 왓으면 바로 팝할수있어야 조건이 만족함
            }else if(stack.peek() != num){
                System.out.println("NO");
                return;
            }
            //그리고 맨위에 값은 원하는 값이니까 pop
            stack.pop();
            result.add("-");
        }

        //출력용
        for(String s: result){
            System.out.print(s);
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 8, 7, 5, 2, 1};
        solution(nums);

        System.out.println("=====");
        nums = new int[]{1, 2, 5, 3, 4};
        solution(nums);
    }
}
