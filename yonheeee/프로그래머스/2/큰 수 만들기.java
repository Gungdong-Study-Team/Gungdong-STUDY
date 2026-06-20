//0 ~ number.length-k에서 가장 큰 수 첫자리
// 첫자리부터 ~ number.length-k-1 ~ 다음으로 가장 큰 수 이렇게 k == 0이 될때까지
class Solution {
    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        
        int len = number.length() - k;
        int start = 0;
        
        for(int i = 0; i < len; i++){
            char max = '0';
            int idx = start;
            
            //최댓값
            for(int j = start; j <= i+k ; j++){
                if(number.charAt(j) > max){
                    max = number.charAt(j);
                    idx = j;
                }
            }
            
            sb.append(max);
            start = idx+1;
        }

        
        return sb.toString();
    }
}