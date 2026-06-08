// k번으로 도착점 도착, 2번이상 방문 가능, 안되면 impossible
// n,m : 격자 크기 / x,y: 출발 위치 / r,c : 탈출 지점 / k : 탈출 이동거리
// l : 왼쪽 / r : 오른쪽 / u : 위쪽 / d : 아래쪽
// 모든 경우의 수, bfs -> 시간초과
// 가지치기

class Solution {
    static char[] sel;
    static int count;
    static String answer = null;

    static int[] dr = {1, 0, 0, -1}; // d l r u
    static int[] dc = {0, -1, 1, 0};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        sel = new char[k];

        dfs(n, m, x, y, r, c, k);

        return answer == null ? "impossible" : answer;
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int k) {
        
        if(answer != null) return;
        
        //가지치기
        int dist = Math.abs(x - r) + Math.abs(y - c);
        int remain = k - count;
        
        if(dist > remain) return;
        if((remain - dist) % 2 == 1) return;
        
        if(count == k) {
            if(x == r && y == c) {
                answer = new String(sel);
            }
            return;
        }

        for(int d = 0; d < 4; d++) {

            int nr = x + dr[d];
            int nc = y + dc[d];

            // 문제 좌표는 1부터 시작
            if(nr < 1 || nr > n || nc < 1 || nc > m) continue;

            switch(d) {
                case 0:
                    sel[count] = 'd';
                    break;
                case 1:
                    sel[count] = 'l';
                    break;
                case 2:
                    sel[count] = 'r';
                    break;
                case 3:
                    sel[count] = 'u';
                    break;
            }

            count++;
            dfs(n, m, nr, nc, r, c, k);
            count--;
        }
    }
}