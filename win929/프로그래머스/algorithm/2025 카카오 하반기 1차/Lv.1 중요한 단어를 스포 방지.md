# 중요한 단어를 스포 방지

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 1 |
| 날짜 | 2026-06-18 |
| 알고리즘 | 문자열, 구현, 해시를 사용한 집합과 맵 |

## 문제 링크

[2025 카카오 하반기 1차 > 중요한 단어를 스포 방지](https://school.programmers.co.kr/learn/courses/30/lessons/468370)

## 풀이 과정

옛날에 풀려다가 포기한 문제다.  
최대한 예쁘게 코드를 짜려다가 머리가 아파져서 포기했던 것 같다.  
그냥 무식하게 더럽게 풀었더니 맞았다.

## 처음 내 코드

```java
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
```

## 수정된 코드

객체와 리스트를 걷어낸 버전이다.

```java
import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        boolean[] hidden = new boolean[n];

        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                hidden[i] = true;
            }
        }

        Set<String> normalWords = new HashSet<>();
        Set<String> spoilerWords = new HashSet<>();

        int i = 0;
        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;
            boolean isSpoilerWord = false;

            while (i < n && message.charAt(i) != ' ') {
                if (hidden[i]) {
                    isSpoilerWord = true;
                }
                i++;
            }

            String word = message.substring(start, i);

            if (isSpoilerWord) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }
        }

        int answer = 0;
        for (String word : spoilerWords) {
            if (!normalWords.contains(word)) {
                answer++;
            }
        }

        return answer;
    }
}
```

## 회고

객체와 리스트를 최대한 안 쓰고 싶었지만 머리가 복잡해서 결국 그냥 좀 더럽게 풀었다.  
오랜만에 푸는 문제라 그런지 아직 삐그덕거린다.  
연습하자.
