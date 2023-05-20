
import java.util.*;
class TwoPoints {
    public static void main(String[] args){
        String[] gems={"A", "B", "A", "B", "A", "B", "A", "B", "A", "C", "B", "A", "B", "A", "B"};
        //투포인터스 문제. java니까 그냥 index 두개로 생각한다.
        Set<String> kinds = new HashSet<>();
        for(String gem : gems){
            kinds.add(gem);
        }
        int gk = kinds.size();//총 보석의 종류 카운팅.
        System.out.println("gem has "+ gk +" of kinds");
        
        Map<String, Integer> perc = new HashMap<String, Integer>();
        int start = 0;//시작 index
        int size = -1;//최소 길이
        
        boolean find = false; // 작업 제어용 변수
        int[] answer = new int[2];//답이 n+1인것에 주의
        
        for(int end = 0; end<gems.length; end++){
            System.out.println("end at : "+ end);
            int n = perc.getOrDefault(gems[end], 0);
            perc.put(gems[end], n+1);
            while(perc.size()==gk){//전부 구매함
                //시작 index를 증가시키며 해당 위치의 값을 감소
                if(!find) find=true;
                int k = perc.get(gems[start]);
                k--;
                if(k == 0){
                    //구매한 보석이 0개면 제거
                    perc.remove(gems[start]);
                }else{
                    perc.put(gems[start], k);
                }
                System.out.println("start at : "+ start);
                start++;
            }
            if(find){
                //보석수 카운팅이 최대-1이고 해당 구간의 최소위치를 찾은 상태.
                find =false;
                int length = end-start+1;
                if(size == -1 || size>length){
                    //최초거나 최소길이를 찾으면...
                    answer[0] = start;//start는 1증가한 상태이므로 그대로 대입
                    answer[1] = end+1;
                    size = length;
                }
            }
            
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}