import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        //Arrays.copyOfRange
        for(int i = 0; i < commands.length; i++){
            int[] check = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(check);
            answer[i] = check[commands[i][2]-1];
            
        }
        return answer;
    }
}