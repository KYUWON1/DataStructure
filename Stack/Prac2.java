package Stack;// Practice2
// 괄호 짝 검사

// 입출력 예시)
// 입력: "("
// 출력: Fail

// 입력: ")"
// 출력: Fail

// 입력: "()"
// 출력: Pass

import java.util.Stack;

public class Prac2 {
    public static void checkParenthesis(String str) {
        Stack stack1 = new Stack();
        boolean isPass = true;

        for(String s: str.split("")){
            if(s.equals("(")){
                stack1.push(s);
            }else {
                if(stack1.isEmpty()){
                    isPass = false;
                    break;
                }
                stack1.pop();
            }
        }
        if(isPass == true && stack1.isEmpty()){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
        }

    }

    public static void main(String[] args) {
        // Test code
        checkParenthesis("(");          // FAIL!
        checkParenthesis(")");          // FAIL!
        checkParenthesis("()");         // PASS!
        checkParenthesis("()()()");     // PASS!
        checkParenthesis("(())()");     // PASS!
        checkParenthesis("(((()))");    // FAIL!
    }
}
