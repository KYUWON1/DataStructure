package Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class Baek1021 {
    public static LinkedList makeList(int size){
        LinkedList que = new LinkedList();
        for (int i = 1; i <= size; i++) {
            que.add(i);
        }
        return que;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int num = sc.nextInt();
        sc.nextLine();

        //찾을 번호들 저장
        int[] arr = new int[num];
        String[] str = sc.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 큐 생성
        LinkedList que = makeList(size);
        int cnt = 0;
        System.out.println(que);
        for (int i = 0; i < arr.length; i++) {
            int idx = que.indexOf(arr[i]); // 인덱스발견하기
            if(idx <= que.size() / 2){
                while((int)que.peek() != arr[i]){
                    que.add(que.poll()); // 이게 왼쪽으로 이동
                    cnt++;
                }
                que.poll();
            }else{
                while((int)que.peek() != arr[i]){
                    que.add(0,que.removeLast()); //오른쪽 이동
                    cnt++;
                }
                que.poll();
            }
        }
        System.out.println(cnt);

    }
}
