
import java.util.*;
class Tree1 {
    public int solution(int[] scoville, int K) {
        //heap 활용 문제
        //heap에서 2개를 poll해서 가공하고 offer, 그뒤 peek이 K보다 큰지 체크
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville){
            queue.offer(i);
        }
        while(queue.peek()<K&&queue.size()>1){
            int i1 = queue.poll();
            int i2 = queue.poll();
            queue.offer(i1+i2*2);
            count++;
        }
        if(queue.peek()<K)return -1;
        return count;
    }
}