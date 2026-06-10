import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        // 시간초과
        // for(int i = 0; i < numbers.length; i++){
        //     for(int j = i; j < numbers.length; j++){
        //         if(numbers[i] < numbers[j]){
        //             answer[i] = numbers[j];
        //             break;
        //         }
        //     }
        // }
        
        //스택이용
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                int diff = stack.pop();
                answer[diff] = numbers[i];      
            }
            stack.push(i);
        }
        
        
        return answer;
    }
}