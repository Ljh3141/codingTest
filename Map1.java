import java.util.*;
class Map1 {
    public int solution(int[] nums) {
        int picks = nums.length/2;
        int kinds = 0;
        Map<Integer, Integer> mons = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(mons.put(nums[i], 1)==null){
            kinds++;
            }
        }
        int answer = 0;
        if(picks>kinds) answer=kinds;
        else answer = picks;
        return answer;
    }
}
