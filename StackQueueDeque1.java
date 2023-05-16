//Queue : offer, poll, peek;
//Stack : push, pop, peek;
//Deque : exception 발생 : addFirst(), removeFirst(), getFirst(),addLast(), removeLast(), getLast();
//Deque : null 발생 : offerFirst(), pollFirst(), peekFirst(),offerLast(), pollLast(), peekLast();

import java.util.*;

class StackQueueDeque1  {
    boolean solution(String s) {
        char[] c = s.toCharArray();
        boolean answer = true;
        int level = 0;
        for(int i = 0 ; i<c.length; i++){
            if(c[i]=='(') level++;
            else level--;
            if(level<0){
                answer =false;
                break;
            }
        }
        if(level!=0) answer = false;

        return answer;
    }
}
