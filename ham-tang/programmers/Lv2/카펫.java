class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = {};
        int total = brown + yellow;
        
        int h, w;
        for(w=3;w<total;w++){
            // i : 가로
            if(total % w == 0){
                h = total/w;
                
                if((h-2) * (w-2) == yellow){
                    answer = new int[]{w, h};
                }
            }
        }
        
        return answer;
    }
}