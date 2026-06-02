import java.util.*;

class Solution {
    static final int N = 11;
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int r = 5;
        int c = 5;
        int answer = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            int nr = r;
            int nc = c;
            
            if (dirs.charAt(i) == 'U') {
                nr = r - 1;
            } else if (dirs.charAt(i) == 'L') {
                nc = c - 1;
            } else if (dirs.charAt(i) == 'R') {
                nc = c + 1;
            } else if (dirs.charAt(i) == 'D'){
                nr = r + 1;
            }
            
            if (!check(nr, nc)) continue;
            
            String path1 = r + "," + c + "," + nr + "," + nc;
            String path2 = nr + "," + nc + "," + r + "," + c;
            if (!visited.contains(path1)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
            
            r = nr;
            c = nc;
        }
        
        return answer;
    }
    
    public boolean check(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }
}