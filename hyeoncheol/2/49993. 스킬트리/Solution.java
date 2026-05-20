import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i + 1);
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            int idx = 1;
            boolean flag = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char ch = skill_trees[i].charAt(j);
                if (map.getOrDefault(ch, 0) == 0) {
                    continue;
                }  else if (map.getOrDefault(ch, 0) == idx) {
                    idx++;
                } else {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
        }
        
        return answer;
    }
}