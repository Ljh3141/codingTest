import java.util.*;
class Map3 {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothMap = new HashMap<String, Integer>();
        for(String[] data : clothes){
            Integer num = clothMap.get(data[1]);
            if(num==null){
                clothMap.put(data[1], 1);
            }else{
                clothMap.put(data[1], num+1);
            }
        }
        Iterator<String> iter =  clothMap.keySet().iterator();
        int answer = 1;
        while(iter.hasNext()){
            answer *= clothMap.get(iter.next())+1;
        }
        return answer-1;
    }
}