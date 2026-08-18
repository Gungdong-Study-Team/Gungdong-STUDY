import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] answer = new int[2];

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("D 1") && !map.isEmpty()) {
                // 최댓값 삭제
                int key = map.lastKey();

                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }

            } else if (operations[i].equals("D -1") && !map.isEmpty()) {
                // 최솟값 삭제
                int key = map.firstKey();

                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }

            } else if (operations[i].startsWith("I")) {
                String[] str = operations[i].split(" ");
                int number = Integer.parseInt(str[1]);

                map.put(number, map.getOrDefault(number, 0) + 1);
            }
        }

        if (map.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }

        return answer;
    }
}