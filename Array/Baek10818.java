package Array;

import java.util.Scanner;

public class Baek10818 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] numArr = new int[size];
        for (int i = 0; i < size; i++) {
            numArr[i] = sc.nextInt();
        }
        sc.nextLine();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a:numArr){
            if(max < a){
                max = a;
            }
            if( min > a){
                min = a;
            }
        }
        System.out.println(min+" "+max);
    }
}
