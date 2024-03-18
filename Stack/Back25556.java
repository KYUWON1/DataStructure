package Stack;

import java.util.Scanner;
import java.util.Stack;
//백준 25556 문제
//문제만 잘 이해하면 쉽다 ! 

public class Back25556 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[len];
        String data = sc.nextLine();
        String[] dataArr = data.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(dataArr[i]);
        }

        Stack<Integer>[] stacks = new Stack[4];
        for (int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
            stacks[i].push(0);
        }

        for (int i = 0; i < len; i++) {
            boolean isCan = false;
            for (int j = 0; j < 4; j++) {
                if(stacks[j].peek() < arr[i]){ //꺼낸 순서대로 마지막 배열로 들어감
                    // 작은게 아래에 깔려야함
                    // 성공 부분 i만 1증가.
                    // 스택에 넣기 실패하면 isCan은 false
                    stacks[j].push(arr[i]);
                    isCan = true;
                    break;
                }
            }
            if(!isCan){
                System.out.println("NO");
                return;
            }
        }
        //성공하면 출력
        System.out.println("YES");
    }
}
