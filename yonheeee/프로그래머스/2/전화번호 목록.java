import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> phone = new HashSet<>(Arrays.asList(phone_book));
        
        for(String book : phone_book){
            for(int i = 0; i < book.length(); i++){
                // 확인할 숫자 확인
                String first = book.substring(0,i);
                
                // 있는지 확인
                boolean check = phone.contains(first);
                
                if(check){
                    return false;
                }
            }
        }
        
        return answer;
    }
}