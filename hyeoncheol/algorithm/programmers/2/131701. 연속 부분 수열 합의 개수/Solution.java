import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new TreeSet<>();
        
        int seq = 1;
        for (int i = 0; i < elements.length; i++) { // 원소 개수 만큼 반복
            for (int j = 0; j < elements.length; j++) { // 각 원소 선택
                int tmp = 0;
                for (int k = 0; k < seq; k++) {
                    tmp += elements[(j + k) % elements.length];
                }
                set.add(tmp);
            }
            seq++;
        }
        
        return set.size();
    }
}