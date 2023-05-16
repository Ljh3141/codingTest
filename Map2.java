import java.util.*;
class Map2 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> comp = new HashMap<String, Integer>();
        for(int i = 0; i<completion.length; i++){
            Integer k = comp.get(completion[i]);
            if(k!=null){
                comp.put(completion[i], k+1);
            }else{
                comp.put(completion[i], 1);
            }
        }
        String answer = "";
        for(int i = 0; i<participant.length; i++){
            Integer k =comp.get(participant[i]);
            if(k==null || k==0) {
                answer=participant[i];
                break;   
            }
            comp.put(participant[i], k-1);
        }
        return answer;
    }
}