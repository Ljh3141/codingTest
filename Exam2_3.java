import java.util.*;
class Exam2_3 {
    public static void main(String[] args){
        int[] menu = {5};
        int[] order = {0,0};
        int k = 10;
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        //매초 체크.
        int time = 0;
        int workDone = 0;
        int index = 0;
        boolean working = false;
        while(queue.size()>0 || index<order.length){
            if(time==workDone && working){
                queue.poll();//손님 내보내기
                working=false;
                //System.out.println("Q out "+time);
            }
            if(time%k==0 && index<order.length){
                //손님 들어옴.
                queue.offer(order[index++]);
                //System.out.println("Q in "+time);
            }
            if(queue.size()>0 &&!working){
                //새 작업 시작.
                workDone= time+menu[queue.peek()];
                //System.out.println("work start "+queue.peek()+" "+workDone);
                working =true;
            }
            time++;
            if(answer<queue.size())answer=queue.size();
        }
        System.out.println(answer);
    }
}
/*
 import java.util.*;
class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        int outTime = 0; //작업이 종료될 때마다 체크 or k초마다 체크
        int inTime = 0;
        int index = 0;
        int count = 0;
        queue.offer(order[index++]);
        answer++;
        inTime+=k;
        while(queue.size()>0 || index < order.length){
            int t = queue.poll();
            //주문 받음.
            outTime += menu[t];
            
           // System.out.println("Order fetched : "+outTime);
            //주문 처리.
            while(inTime<=outTime && index < order.length){//주문을 처리한 시점에 들어온 손님이 있다면..
                inTime+=k;
                queue.offer(order[index++]);//해당 손님을 추가.
            }
            if(queue.size()==0 && index < order.length){
                //큐에 아무도 없는데 아직 끝나지 않았다
                //주문을 처리했는데 온 손님이 없다..!
                //다음 손님이 올때까지 대기.
                
                outTime = index*k; //다음 손님이 온 시간은 다음번손님 순서*k초다.
                inTime = index*k;
                queue.offer(order[index++]);
            }
            //System.out.println("size "+queue.size());
            count = inTime<outTime?1:0;
            count += queue.size();
            if(answer<count) answer =count;
        }
        return answer;
    }
}
 */