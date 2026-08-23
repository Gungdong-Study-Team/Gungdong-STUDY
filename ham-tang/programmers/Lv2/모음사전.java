import java.util.*;

class Solution {
    char[] chars = {'A', 'E', 'I', 'O', 'U'};
    int answer = 0;
    int count = 0;
    public int solution(String word) {
        
        dfs("", word);        
        
        return answer;
    }
    
    void dfs(String str, String word){
        if(str.equals(word)){
            answer = count;
            return;
        }
        
        if(str.length() == 5)
            return;
        
        for(int i=0;i<5;i++){
            count++;
            dfs(str+chars[i], word);
            
            if(answer != 0) return;
        }
    }
}