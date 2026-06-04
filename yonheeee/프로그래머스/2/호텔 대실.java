// 최대 겹치는 시간 수
// 시간 -> 분으로 바꾸는 공부
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[] day = new int[1450];
        
        //분 단위로 바꿈
        for(int i = 0; i < book_time.length; i++){
            int start = changeMin(book_time[i][0]);
            int end = changeMin(book_time[i][1]) + 10; //청소시간
            
            //만약에 시간에 있으면 배열 증가
            for(int t = start; t < end; t++){
                day[t]++;
            }
        }
        
        
        int answer = 0;
        for(int i = 0; i < day.length; i++){
            if(day[i] > answer){
                answer = day[i];
            }
        }
        
        return answer;
    }
    
    private int changeMin(String time){
        String[] splitTime = time.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int min = Integer.parseInt(splitTime[1]);
        return (hour*60) + min;
    }
}