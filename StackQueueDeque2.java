import java.util.*;
class StackQueueDeque2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i = 0; i<progresses.length; i++){
            float p = progresses[i];
            float s = speeds[i];
            
            days[i] = (int)Math.ceil((100-p)/s);
        }
        List<Integer> arr = new ArrayList();
        int post = days[0];
        int count=1;
        for(int i=1; i<days.length; i++){
            if(days[i]>post){
                post=days[i];
                arr.add(count);
                count=1;
            }else count++;
        }
        arr.add(count);
        int[] answer = arr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

/*
import java.util.*;

class StackQueueDeque2 {
    public static void main(String[] args){
        int[] progresses = {1,1,1,1,1,1};
        int[] speeds = {1,1,1,1,1,1};
        
        Queue<Data> data = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < progresses.length ; i++){
            data.offer(new Data(progresses[i], speeds[i]));
        }
        while(!data.isEmpty()){
            for(int i = 0 ; i< data.size() ; i++){
                //작업 진행
                Data now = data.poll();
                now.work();
                data.offer(now);
            }
            int count= 0;
            while(data.peek().prog>100){
                count++;
                data.poll();
                if(data.isEmpty())break;
            }
            if(count>0){
                list.add(count);
            }
        }
        System.out.println(list);
        
    }
}

class Data {
    public int prog;
    int speed;
    public Data(int prog, int speed){
        this.prog = prog;
        this.speed = speed;
    }
    public void work(){
        prog+=speed;
    }
    
}
 */
/*import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Data> data = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < progresses.length ; i++){
            data.offer(new Data(progresses[i], speeds[i]));
        }
        while(!data.isEmpty()){
            for(int i = 0 ; i< data.size() ; i++){
                //작업 진행
                Data now = data.poll();
                now.work();
                data.offer(now);
            }
            int count= 0;
            while(data.peek().prog>100){
                count++;
                data.poll();
                if(data.isEmpty())break;
            }
            if(count>0){
                list.add(count);
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}

class Data {
    public int prog;
    int speed;
    public Data(int prog, int speed){
        this.prog = prog;
        this.speed = speed;
    }
    public void work(){
        prog+=speed;
    }
    
} */