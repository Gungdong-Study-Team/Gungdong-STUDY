import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int p : people) {
            list.add(p);
        }
        
        Collections.sort(list);
        
        while (!list.isEmpty()) {
            if (list.size() == 1) { // list에 1개만 남아있음
                answer++;
                list.remove(0);
                continue;
            } else if ((list.get(0) + list.get(list.size() - 1)) <= limit) {
                list.remove(list.size() - 1);
                list.remove(0);
                answer++;
            } else {
                list.remove(list.size() - 1);
                answer++;
            }
        }
        
        return answer;
    }
}