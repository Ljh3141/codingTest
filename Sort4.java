
import java.util.*;
class Sort4 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i<citations.length ; i++){
            int k = citations.length-i;
            if(citations[i]>=k)return k;
        }
        return 0;
    }
}
/*
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Integer[] arr = new Integer[citations.length];
        for(int i=0; i < citations.length; i++){
            arr[i] = citations[i];
        }
        Arrays.sort(arr,Comparator.reverseOrder());
        for(int i = 0; i<arr.length; i++){
            if(arr[i]<=i+1)return i;
        }
        return 0;
    }
}
 */