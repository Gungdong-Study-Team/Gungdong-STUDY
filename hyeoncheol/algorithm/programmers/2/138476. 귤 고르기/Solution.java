import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10_000_001];
        
        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]]++;
        }
        
        Arrays.sort(arr);
        
        int idx = arr.length - 1; 
        while (k > 0) {
            k -= arr[idx];
            answer++;
            idx--;
        }
        
        return answer;
    }
}