import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] arr = s.split(" ");
        
        for (String str : arr) {
            int num = Integer.parseInt(str);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        return min + " " + max;
    }
}