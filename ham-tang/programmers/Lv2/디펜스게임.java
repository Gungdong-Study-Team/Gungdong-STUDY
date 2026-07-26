import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
     
        int enemy_size = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int e: enemy){
            if(k>0){
                k--;
                pq.offer(e);
            }else{
                int now = pq.poll();
                if(now < e){
                    pq.offer(e);
                    n -= now;
                }else{
                    n-= e;
                    pq.offer(now);
                }
                if(n < 0)  break;
            } 
            answer ++;
        }
        
        return answer;
    }
}