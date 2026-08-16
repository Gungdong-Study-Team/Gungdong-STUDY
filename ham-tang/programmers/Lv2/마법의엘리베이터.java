class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10; // 일의 자리
            int nextDigit = (storey / 10) % 10; // 다음 십의 자리
            
            if (digit > 5) {
                // 5보다 크면 더해서 0으로 만드는 것이 이득
                answer += (10 - digit);
                storey += 10; // 올림 처리
            } else if (digit < 5) {
                // 5보다 작으면 빼서 0으로 만드는 것이 이득
                answer += digit;
            } else {
                // 정확히 5인 경우, 다음 자릿수를 보고 결정
                if (nextDigit >= 5) {
                    answer += 5;
                    storey += 10; // 다음 자리가 5이상이면 같이 올려버리는 게 이득
                } else {
                    answer += 5; // 다음 자리가 작으면 그냥 내리는 게 이득
                }
            }
            
            storey /= 10; // 다음 자릿수로 이동
        }
        
        return answer;
    }
}