import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b) -> (b+a).compareTo(a+b));
        
        for(int i: numbers){
            pq.offer(""+i);
        }
        
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        boolean flag = false;
        for(int i=1;i<=9;i++){
            if(answer.indexOf(""+i)!=-1) {flag = true; break;}
        }
        
        return flag?answer:"0";
    }
}

/** 아래 코드는 처음 시도 : 시간 초과
 * 
 * 조합해서 완탐으로 최댓값 구하기 -> 역시나 시간초과!
 */

// class Solution {

//     long maxNum = Long.MIN_VALUE;
//     int n;
//     String answer = "0";
    
//     public String solution(int[] numbers) {
//         n = numbers.length;
        
//         comb(numbers, 0, new int[n], 0);
        
//         // answer = ""+maxNum;
        
//         return answer;
//     }
    
//     void comb(int[] numbers, int depth, int[] sel, int flag){
//         if(depth == n){
//             StringBuilder sb = new StringBuilder();
//             for(int i: sel){
//                 sb.append(i);
//                 // System.out.print(i+" ");
//             }
//             // System.out.println(sb.toString());
//             // maxNum = Math.max(maxNum, Long.parseLong(sb.toString()));
//             if(answer.compareTo(sb.toString()) < 0){
//                 answer = sb.toString();
//             }
            
//             return;
//         }    
        
//         for(int i=n-1; i>=0;i--){
//             if((flag & (1<<i)) != 0) continue;
//             sel[depth] = numbers[i];
//             comb(numbers, depth+1, sel, flag | (1<<i));
//         }
//     }
// }