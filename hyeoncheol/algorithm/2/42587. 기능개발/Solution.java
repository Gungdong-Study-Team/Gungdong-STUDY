import java.util.*;

class Solution {
    static class Process {
        int idx, rank;

        Process(int idx, int rank) {
            this.idx = idx;
            this.rank = rank;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Process> q = new ArrayDeque<>();
        int n = priorities.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            q.offer(new Process(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            Process now = q.poll();
            boolean flag = false;

            for (Process p : q) {
                if (p.rank > now.rank) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                q.offer(now);
            } else {
                answer++;
                if (location == now.idx) {
                    return answer;
                }
            }
        }
        return answer;
    }
}