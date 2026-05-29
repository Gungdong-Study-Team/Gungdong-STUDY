class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        solve(0, 0, numbers, target);
        return answer;
    }
    
    public void solve(int idx, int current, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (current == target) answer++;
            return;
        }
        
        solve(idx + 1, current + numbers[idx], numbers, target);
        solve(idx + 1, current - numbers[idx], numbers, target);
    }
}