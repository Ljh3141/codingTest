public class Array1 {
    public int[] solution(int[] arr) {
        int maxNum=arr[0];
        int index=0;
        int count=1;
        if(arr.length==1){
            int[] a = {0};
            return a;
        }
        for(int i = 1; i<arr.length; i++){
                if(arr[i]>maxNum){
                    maxNum=arr[i];
                    index=i;
                    count=1;
                }
                else{
                    if(arr[i]==maxNum){
                        count++;
                    }
                }
        }
        int[] answer = new int[count];
        count=0;
        for(int i = 0; i<arr.length; i++){
            if(maxNum==arr[i]){
                answer[count++]=i;
            }
        }
        return answer;
    }
}
