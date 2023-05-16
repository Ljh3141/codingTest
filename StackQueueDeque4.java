import java.util.*;
class StackQueueDeque4 {
    public int solution(int[] priorities, int location) {
        Queue<Data> datas = new LinkedList<>();
        int answer = 0;
        boolean waiting = true;
        for(int i = 0; i<priorities.length; i++){
            datas.offer(new Data(priorities[i],i==location));
        }
        while(waiting){
            Data data = datas.poll();
            boolean excute=true;
            for(int i = 0; i<datas.size(); i++){
                Data tmp = datas.poll();
                if(data.pr <tmp.pr){
                    excute = false;
                }
                datas.offer(tmp);
            }
            if(excute) answer++;
            if(excute&&data.me)break;
            if(!excute)datas.offer(data);
            
        }
        return answer;
    }
}

class Data{
    public boolean me;
    public int pr;
    public Data(int pr,boolean me){
        this.me = me;
        this.pr = pr;
    }
}