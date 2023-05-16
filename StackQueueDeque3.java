public class StackQueueDeque3 {
    public static void main(String[] args){
        int[] prices = {1,2,3,2,3};
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length-1; i++){
            for(int j = i+1; j<prices.length; j++){
                answer[i]++;
                if(prices[i]>prices[j]){
                    break;
                }
            }
        }
        for(int i : answer){
            System.out.print(i+" ");
        }
    }
    
}
