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
            if((char)stack.peek()=='('&&ch==')'){

                stack.pop();
            }
            else if((char)stack.peek()=='{'&&ch=='}'){
                stack.pop();
            }
            else if((char)stack.peek()=='['&&ch==']'){
                stack.pop();
            }else{
                char push = (char)stack.push(str.charAt(i));
                if(push=='}'||push==']'||push==')'){
                    System.out.println(false);
                    return ;
                }
            }
        }
        if(stack.empty()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
