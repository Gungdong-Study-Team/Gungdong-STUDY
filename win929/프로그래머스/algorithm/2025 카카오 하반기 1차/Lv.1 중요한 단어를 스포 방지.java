import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        String[] strs = message.split(" ");
        boolean[] mosaics = new boolean[message.length()];
        for (int[] a : spoiler_ranges) {
            for (int i = a[0]; i <= a[1]; i++) {
                mosaics[i] = true;
            }
        }
        
        ArrayList<Word> words = new ArrayList<>();
        HashSet<String> nots = new HashSet<>();
        
        int start = 0;
        int end = 0;
        for (String s : strs) {
            end = start + s.length() - 1;
            Word temp = new Word(s, start, end);
            
            for (int i = start; i <= end; i++) {
                if (mosaics[i]) {
                    temp.isMosaic = true;
                    break;
                }
            }
            
            words.add(temp);
            
            if (!temp.isMosaic && !nots.contains(temp.str)) {
                nots.add(temp.str);
            }
            
            start = end + 2;
        }
        
        HashSet<String> importants = new HashSet<>();
        
        for (Word w : words) {
            if (w.isMosaic && !nots.contains(w.str) && !importants.contains(w.str)) {
                importants.add(w.str);
            }
        }
        
        return importants.size();
    }
}

class Word {
    String str;
    int start;
    int end;
    boolean isMosaic;
    
    Word(String str, int start, int end) {
        this.str = str;
        this.start = start;
        this.end = end;
        this.isMosaic = false;
    }
}