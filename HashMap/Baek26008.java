package HashMap;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baek26008 {
    public static int decode(int[] arr){
        int size = arr[0];
        int mod = arr[1];
        int mul = arr[2];
        int hash = arr[3];
        int Cnt = 0;
        int[] result = new int[size];
        for (int i = 0; i < mod; i++) { // 0 1 2
            result[i] = i;
            for (int j = 0; j < mod; j++) {
                result[j] = j;
                for (int k = 0; k < mod; k++) {
                    result[k] = k;
                    if(hash == unhash(result,mod,mul)){
                        Cnt++;
                    }
                }
            }
        }

        return Cnt;
    }

    public static int unhash(int[] arr,int mod,int mul){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * (int)Math.pow(mul,i);
            //System.out.println(sum);
        }
        return sum % mod;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //비밀번호 길이, 가능한 정수 범위, 정수A, 해쉬값
        int[] data = new int[4];
        for (int i = 0; i < 4; i++) {
            data[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println(decode(data));

    }
}
