import java.util.*;

class Set1 {
    public boolean solution(int[] lotto) {
        Set<Integer> nums = new HashSet<>();
        for(int i =0; i<lotto.length; i++){
            nums.add(lotto[i]);
        }
        
        boolean answer = nums.size()==6;
        return answer;
    }
}