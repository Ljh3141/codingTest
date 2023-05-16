
import java.util.*;

class Array2  {
    public boolean solution(int[] arr) {
        boolean answer = true;
        Arrays.sort(arr);
        if(arr.length==1&& arr[0]==1)return true;
        else if(arr.length==1&& arr[0]!=1)return false;
        for(int i = 0; i<arr.length; i++){
            if(i+1!=arr[i]) answer=false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(arr[0]);

        return answer;
    }
}
