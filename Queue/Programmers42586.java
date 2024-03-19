package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers42586 {

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] dayCheck = new int[progresses.length];

        while(true){
            boolean flag = true;

            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if(progresses[i] < 100){
                    flag = false;
                    dayCheck[i]++; // 걸린일수를 하나씩 올려줌
                }
            }
            if(flag){ // 모든 배포가 계산이 끝났을때 break;
               break;
            }
        }


        //dayCheck에는 7 3 9 가 있다 .
        int size = 0;

        for (int i = 0; i < dayCheck.length-1; i++) {
            int max = dayCheck[i]; //우선 가장 첫번째값 대입
            for (int j = i+1; j < dayCheck.length; j++) {

            }
        }
        int[] answer = {};
        return answer;
    }


    public static void main(String[] args){
        int[] arr1 = {93,30,55};
        int[] arr2 = {1,30,5};
        int[] sol = (solution(arr1,arr2));
        for (int n :sol) {
            System.out.print(n+" ");
        }
    }
}
