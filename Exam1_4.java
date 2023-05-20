
import java.util.*;
class Exam1_4 {
    //반례 2개
    //1.작업과 작업 사이에 빈 시간이 있는경우
    //2.반례 1에서 두번째 작업이 시작될때 동시에 시작하는 우선순위가 높은 작업이 있는경우.
    
    
    public long[] solution(int[][] program) {
        Arrays.sort(program, (o1, o2)->{
            return o1[1]-o2[1];
        });//호출 시간 순으로 정렬
        long time = program[0][1];//시간 집계
        Queue<Integer>[] queue = new Queue[10];
        for(int i = 0; i<queue.length;i++)queue[i] = new LinkedList<Integer>();
        queue[program[0][0]-1].offer(0); //최초 프로그램을 삽입.
        int next = 1; //다음 작업 포인터
        long[] wait = new long[11];
        while(allQueueRemain(queue)||next<program.length){
            //queue에 하나라도 있다면 계속 돈다.
            int nextT = next;
            while(next<program.length && program[next][1]<=time){
                //작업 추가
                //System.out.println("time : "+time+" add : "+next);
                queue[program[next][0]-1].offer(next);//우선순위에 따라서 작업 추가.
                next++;
            }
            int now;
            if(nextT==next&&!allQueueRemain(queue)){
                //작업이 남았으나 큐에 작업이 없음. 시간을 앞으로 진행 시켜야함.
                //반례 : 다음 작업이 여러개일 경우.
                time = program[next][1];
                while(next<program.length && program[next][1]<=time){
                    //작업 추가
                    //System.out.println("time : "+time+" add : "+next);
                    queue[program[next][0]-1].offer(next);//우선순위에 따라서 작업 추가.
                    next++;
                }
                now = getNext(queue);
            }else{
                now = getNext(queue);//이번 작업 구해옴   
            }
            //시간체크 및 대기시간 추가.
            //대기시간 = 현재 시각-호출 시각
            wait[program[now][0]]+=time-program[now][1];//우선순위에 대기시간추가.
            time+=program[now][2];//프로그램 실행
            //System.out.println("Run "+now);
        }
        wait[0] = time;
        return wait;
    }
    //큐에 남은 작업 체크
    boolean allQueueRemain(Queue<Integer>[] queue){
        for(Queue<Integer> q : queue){
            //우선순위가 높은 작업을 먼저 호출.
            //큐이므로 먼저 호출된 작업이 먼저 반환됨.
            if(q.size()>0)return true;
        }
        return false;
    }
    //다음 작업 반환
    int getNext(Queue<Integer>[] queue){
        for(Queue<Integer> q : queue){
            if(q.size()>0)return q.poll();
        }
        return -1;
    }
}