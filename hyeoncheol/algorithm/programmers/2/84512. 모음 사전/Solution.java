class Solution {
    static int tmp;
    static int answer;
    static String[] s = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        answer = 0;
        tmp = 0;
        solve("", word);
        return answer;
    }
    
    static void solve(String current, String word) {
        if (current.equals(word)) {
            answer = tmp;
        }
        
        if (current.length() == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            tmp++;
            solve(current + s[i], word);
        }
    }
}