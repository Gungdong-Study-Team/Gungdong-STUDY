// 일단 순서대로 채우는데 줄어드는 count++
// 백트래킹?

import java.util.*;

class Solution {
    static char[] vowel = {'A','E','I','O','U'};
    static char[] alpha = new char[5];
    static int count;
    
    public int solution(String word) {
        count = 0;
        int answer = backtracking(0,word);
        return answer;
    }
    
    private int backtracking(int index, String word){
    
        //String.valueOf(배열, 시작점, 길이) -> String으로 반환
        if(String.valueOf(alpha,0,index).equals(word)){
            return count;
        }
        
        if(index == 5){
            return 0;
        }
        
        for(int i = 0; i < 5; i++){
            alpha[index] = vowel[i];
            count++;
            int result = backtracking(index+1, word);
            
            if(result != 0) {
                return result;
            }
        }
        return 0;
    }
    
}