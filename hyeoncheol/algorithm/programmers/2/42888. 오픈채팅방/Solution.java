import java.util.*;
import java.io.*;

class Solution {
    static class Order {
        String cmd;
        String id;
        
        Order(String cmd, String id) {
            this.cmd = cmd;
            this.id = id;
        }
    }
    
    public String[] solution(String[] record) {
        List<Order> orders = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String cmd = st.nextToken();
            String id = st.nextToken();
            
            if (!cmd.equals("Change")) {
                orders.add(new Order(cmd, id));
            }
            
            if (!cmd.equals("Leave")) {
                String name = st.nextToken();
                map.put(id, name);
            }
        }
        
        String[] answer = new String[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            String cmd = orders.get(i).cmd;
            String id = orders.get(i).id;
            String name = map.get(id);
            
            if (cmd.equals("Enter")) {
                answer[i] = name + "님이 들어왔습니다.";
            } else if (cmd.equals("Leave")) {
                answer[i] = name + "님이 나갔습니다.";
            } 
        }
        
        return answer;
    }
}