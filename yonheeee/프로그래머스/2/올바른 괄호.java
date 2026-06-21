import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        
        if(s.charAt(0) == ')'){
            return false;
        }
        //처음은 일단 넣음
        stack.push(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            
            if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')'){
                stack.pop();
                continue;
            }
            //System.out.println(stack);
            
            stack.push(s.charAt(i));
            
            
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return answer;
    }
}