import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 시간
        int currentWeight = 0; // 다리의 현재 무게
        int idx = 0; // 트럭 인덱스
        int pass = 0; // 지나간 트럭
        Queue<Integer> q = new ArrayDeque<>(); // 다리
        
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        
        // 모든 트럭이 지나갈때까지 진행
        while (pass != truck_weights.length) {
            answer++;
            
            // 트럭이 지나가는 작업
            int out = q.poll();
            if (out != 0) {
                currentWeight -= out;
                pass++;
            }
            
            // 트럭을 넣는 작업
            if (idx < truck_weights.length && (currentWeight + truck_weights[idx] <= weight)) {
                q.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                q.offer(0);
            }
        }
       
        return answer;
    }
}

/**
 * 처음에는 트럭 클래스를 사용해서 문제를 풀려고 시도했으나
 * 문제를 풀지 못하였고 결국 대GPT 선생님께 힌트를 얻었으니
 * 다리의 길이만큼 0을 넣고 시도하는 방법을 터득하고 문제를 풀었다.
 * 
 * 처음에 쉬운 문제들을 앞에서 많이 풀어서 그런가 이제 2렙도 버겁다.
 * 
 * 추가로 이전에 내가 풀던 방식인 트럭 클래스 방식도 실제로 해당 문제를 풀 수 있다.
 * 이게 더 쉬울뿐. 혹여나 이 글을 보는 사람이 있다면 그 방법으로 풀어주길...
 * 
 * 커밋 메시지를 쓰다보니 이제 벌써 8월이다. 그렇다 이제 4개월 뒤면 27.. 누군가는 3..
 */