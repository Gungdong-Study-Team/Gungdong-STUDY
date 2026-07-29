import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> s1 = new Stack(); // 컨테이너
        Stack<Integer> s2 = new Stack(); // 보조 컨테이너
        
        int orderNum = 1;
        int idx = 0;
        for(int i=1;i <= order.length;i++){
            if(order[idx] != i){
                s2.push(i);
            }else{
                s1.push(i);
                idx++;
                
                while(!s2.empty() && s2.peek() == order[idx]){
                    s1.push(s2.pop());
                    idx++;
                }
            }
        }
        
        return s1.size();
    }
}