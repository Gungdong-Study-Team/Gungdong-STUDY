import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int start = 0;
        int end = gems.length - 1;
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        int left = 0;
        for (int right = 0; right < gems.length; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            while (map.size() == set.size()) {
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                
                map.put(gems[left], map.get(gems[left]) - 1);
                
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                
                left++;
            }
        }
        return new int[] {start + 1, end + 1};
    }
}