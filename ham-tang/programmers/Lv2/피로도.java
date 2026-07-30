class Solution {
    int answer = 0;
    int stamina;
    
    public int solution(int k, int[][] dungeons) {
        
        int n = dungeons.length;
        stamina = k;
        comb(0, new int[n], 0, n, dungeons);
        
        return answer;
    }
    
    void goDungeons(int[] arr, int[][] dungeons){
        int stamina_copy = stamina;
        int num = 0;
        for(int idx : arr){
            if(stamina_copy < dungeons[idx][0]){    // 최소 필요 피로도 미만이면
                break;
            }
            
            stamina_copy -= dungeons[idx][1];
            num++;
        }
        
        answer = Math.max(num, answer);
    }
    
    void comb(int depth, int[] sel, int flag, int n, int[][] dungeons){
        if(depth == n){
            goDungeons(sel, dungeons);
            return;
        }
        for(int i=0;i<n;i++){
            if((flag & (1<<i)) != 0) continue;
            sel[depth] = i;
            comb(depth+1, sel, (flag | (1<<i)), n, dungeons);
        }
    }
}