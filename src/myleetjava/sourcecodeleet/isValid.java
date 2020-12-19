package myleetjava.sourcecodeleet;

import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        String str = "()[]{}";
        str.replace(" ","");
        Stack stack = new Stack();
        stack.add(str.charAt(0));
        for(int i=1;i<str.length();i++){

            char ch = str.charAt(i);
            if(!stack.empty()&&(char)stack.peek()=='('&&ch==')'){

                stack.pop();
            }
            else if(!stack.empty()&&(char)stack.peek()=='{'&&ch=='}'){
                stack.pop();
            }
            else if(!stack.empty()&&(char)stack.peek()=='['&&ch==']'){
                stack.pop();
            }else{
                char push = (char)stack.push(str.charAt(i));
                if(push=='}'||push==']'||push==')'){
                    System.out.println("1"+false);
                    return ;
                }
            }
        }
        if(stack.empty()){
            System.out.println("3"+true);
        }else{
            System.out.println("2"+false);
        }
    }
}
//class Solution {
//    public boolean isValid(String s) {
//        s.replace(" ","");
//        Stack stack = new Stack();
//        stack.add(s.charAt(0));
//        for(int i=1;i<s.length();i++){
//            char ch = s.charAt(i);
//            if(!stack.empty()&&(char)stack.peek()=='('&&ch==')'){
//                stack.pop();
//            }
//            else if(!stack.empty()&&(char)stack.peek()=='{'&&ch=='}'){
//                stack.pop();
//            }
//            else if(!stack.empty()&&(char)stack.peek()=='['&&ch==']'){
//                stack.pop();
//            }else{
//                char push = (char)stack.push(s.charAt(i));
//                if(push=='}'||push==']'||push==')'){
//                    return false;
//                }
//            }
//        }
//        if(stack.empty()){
//            return true;
//        }else{
//            return false;
//        }
//    }
//}

//class Solution {
//    public boolean isValid(String s) {
//        Stack<Character>stack = new Stack<Character>();
//        for(char c: s.toCharArray()){
//            if(c=='(')stack.push(')');
//            else if(c=='[')stack.push(']');
//            else if(c=='{')stack.push('}');
//            else if(stack.isEmpty()||c!=stack.pop())return false;
//        }
//        return stack.isEmpty();
//    }
//}

//官方
//class Solution {
//    public boolean isValid(String s) {
//        int n = s.length();
//        if (n % 2 == 1) {
//            return false;
//        }
//
//        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
//            put(')', '(');
//            put(']', '[');
//            put('}', '{');
//        }};
//        Deque<Character> stack = new LinkedList<Character>();
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i);
//            if (pairs.containsKey(ch)) {
//                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
//                    return false;
//                }
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//        return stack.isEmpty();
//    }
//}
