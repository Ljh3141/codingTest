
class Sort1 {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[] {-1};
        
        int min = arr[0];
        for(int i : arr){
            if(min>i) min=i;
        }
        int[] answer = new int[arr.length-1];
        int k = 0;
        for(int i : arr){
            if(i==min)continue;
            answer[k++] = i;
        }
        return answer;
    }
}