import java.util.*;

class Solution {
    public Integer[] solution(int[] numbers) {
        Set<Integer> s = new HashSet<>();
        int n = numbers.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int result = numbers[i] + numbers[j];
                s.add(result);
            }
        }
        
        Integer[] answer = s.toArray(new Integer[0]);
        Arrays.sort(answer);
        return answer; 
    }
}