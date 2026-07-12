import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        
        // Arrays.fill(answer, -1);
        int idx = size-1;
        answer[idx--] = -1;
        Stack<Integer> s = new Stack();
        
        for(int i=size-2;i>=0;i--){
            if(numbers[i] < numbers[i+1]){
                s.push(numbers[i+1]);
                answer[idx--] = numbers[i+1];
                continue;
            }else{
                boolean flag = false;
                while(!s.empty()){
                    if(s.peek() > numbers[i]){
                        flag = true;
                        answer[idx--] = s.peek();
                        break;
                    }else{
                        s.pop();
                    }
                }
                if(!flag){
                    answer[idx--] = -1;
                }
            }
        }
        
        
        return answer;
    }
}