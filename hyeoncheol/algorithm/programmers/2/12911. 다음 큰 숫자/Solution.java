class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int nCount = Integer.bitCount(n);
        int answerCount = Integer.bitCount(answer);
        
        while (nCount != answerCount) {
            answer += 1;
            answerCount = Integer.bitCount(answer);
        }
        
        return answer;
    }
}