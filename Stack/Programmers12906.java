package Stack;

import java.util.Stack;

public class Programmers12906 {
    public static int[] solution(int[] arr){
        Stack<Integer> stack = new Stack();
        stack.push(arr[0]);
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if(stack.peek() != arr[i]){ // 가장 윗 값과 중복되지않는다면,
                stack.push(arr[i]);
                cnt++;
            }
        }

        int[] result = new int[cnt];
        for (int i = 1; i <= result.length; i++) {
            result[cnt-i] = stack.pop(); //뒤에 값 부터 들어감
        }
        return result;
    }

    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};

        printArr(solution(arr1));
        printArr(solution(arr2));
    }
}
