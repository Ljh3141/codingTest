
import java.util.*;
class Exam2_2 {
    public int solution(int[] ability, int number) {
        //아마도 그리디 문제..?
        //정렬후 최소인 2개를 뽑아 연산.
        //정렬이 필요없도록 할 수 있을까?
        Arrays.sort(ability);
        for(int i = 0; i<number; i++){
            //0,1을 뽑아 사용
            int result = ability[0]+ability[1];
            ability[1]=ability[0] = result;
            boolean sorted =false;
            //그후, 부분정렬
            for(int j = 2; j<ability.length; j++){
                if(ability[j]>=result){
                    Arrays.sort(ability, 0, j);
                    sorted = true;
                    break;
                }
            }
            if(!sorted) {//모든 데이터를 앞으로 두칸 당기고 결과를 맨뒤에 삽입
                for(int j = 0; j<ability.length-2;j++){
                    ability[j] = ability[j+2];
                }
                ability[ability.length-2] = result;
                ability[ability.length-1] = result;
            }
        }
        int answer = 0;
        for(int i : ability){
            answer+=i;
        }
        return answer;
    }
}