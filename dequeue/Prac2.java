package dequeue;// Practice1
// Palindrome 찾기
// Palindrome 이면 true, 아니면 false 를 반환하세요.
// Palindrome: 앞으로 읽어도 거꾸로 읽어도 같은 문자열

// 입출력 예시)
// 입력: a
// 결과: true

// 입력: madam
// 결과: true

// 입력: abab
// 결과: false


import java.util.ArrayDeque;
import java.util.Deque;

public class Prac2 {
    public static boolean checkPalindrome(String str) {
        boolean isPalin = false;
        Deque deque = new ArrayDeque();
        for(String s: str.split("")){
            deque.addLast(s);
        }
        while(!deque.isEmpty()){
            String str1 = (String)deque.removeFirst();
            if(!deque.isEmpty()){
                if(str1.equals(deque.removeLast())){ //같다면
                    isPalin = true;
                }else{
                    isPalin = false;
                    break;
                }
            }else{
                isPalin = true;
            }
        }
        return isPalin;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(checkPalindrome("a"));       // true
        System.out.println(checkPalindrome("aba"));     // true
        System.out.println(checkPalindrome("abba"));    // true
        System.out.println(checkPalindrome("abab"));    // false
        System.out.println(checkPalindrome("abcba"));   // true
        System.out.println(checkPalindrome("abccba"));  // true
        System.out.println(checkPalindrome("madam"));  // true
    }
}
