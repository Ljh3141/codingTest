import java.util.*;

public class Set3 {
    public int[] solution(int []arr) {
        //set을 어디다써먹어야하는거야 이거
        int k = 1;
        int post = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i]!=post){
                post = arr[i];
                k++;
            }
        }
        int[] answer = new int[k];
        k=1;
        post = answer[0] = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i]==post){
                continue;
            }
            post = answer[k]=arr[i];
            k++;
        }
        

        return answer;
    }
}