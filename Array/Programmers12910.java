package Array;

import java.util.ArrayList;

public class Programmers12910 {
    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }
        if(list.size() == 0){
            list.add(-1);
        }
        int[] answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();

        return answer;
    }
    public static void main(String[] args){
        int[] arr = {1,2,36,3};
        int[] result = solution(arr,1);
        for(int a: result){
            System.out.print(a+" ");
        }
    }
}
