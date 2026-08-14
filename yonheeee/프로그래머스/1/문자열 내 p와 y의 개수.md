## 풀이방법
p와 y의 개수 비교해서 같으면 true

## 코드
```
//p와 y의 개수 같으면 true, 다르면 false

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcnt = 0; int ycnt = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == 'p'|| c =='P')pcnt++;
            if(c == 'y'|| c =='Y')ycnt++;
        }

        return pcnt == ycnt? true : false;
    }
}
```

## 회고
이런 쌀먹 문제도 풀어야 삶이 fuck fuck하지 않죠...</br>

## AI 코드
```
class Solution {
    boolean solution(String s) {
        int count = 0;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') count++;
            else if (c == 'y') count--;
        }

        return count == 0;
    }
}
```