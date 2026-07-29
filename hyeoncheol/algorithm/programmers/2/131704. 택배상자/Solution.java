import java.util.*;

class Solution {
    public int solution(int[] order) {
        int idx = 0;
        Stack<Integer> s = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            s.push(i);
            
            while (!s.isEmpty() && idx < order.length && s.peek() == order[idx]) {
                s.pop();
                idx++;
            }
        }
        return idx;
    }
}