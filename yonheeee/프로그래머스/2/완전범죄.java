// 그냥 조합 시, 시간 초과
// boolean 3차원
import java.util.*;

class Solution {
    static int mina = Integer.MAX_VALUE;
    static boolean[][][] visited;

    public int solution(int[][] info, int n, int m) {
        visited = new boolean[info.length + 1][n][m];
        comb(0, info, 0, 0, n, m);
        return mina == Integer.MAX_VALUE ? -1 : mina;
    }

    private void comb(int idx, int[][] info, int asum, int bsum, int n, int m) {
        // 만약에 n과 m 넘으면
        if (asum >= n || bsum >= m) {
            return;
        }
    
        if (asum >= mina) {
            return;
        }

        if (visited[idx][asum][bsum]) {
            return;
        }

        visited[idx][asum][bsum] = true;

        if (idx == info.length) {
            mina = Math.min(mina, asum);
            return;
        }

        // A가 훔치는 경우
        comb(idx + 1,info, asum + info[idx][0],bsum,n,m);

        // B가 훔치는 경우
        comb(idx + 1,info,asum,bsum + info[idx][1],n,m);
    }
}