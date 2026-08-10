import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        Arrays.sort(book_time, (a, b)->{
            return Integer.compare(getMinute(a[0]), getMinute(b[0]));
        });
        
        PriorityQueue <Integer> pq = new PriorityQueue<Integer>();
        
        for(String[] time : book_time){
            int start = getMinute(time[0]);
            int end = getMinute(time[1]) + 10;
            
            if(!pq.isEmpty() && pq.peek()<=start){
                pq.poll();
            }
            pq.offer(end);
        }
        
        return pq.size();
    }
    
    int getMinute(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        
        return h*60+m;
    }
}