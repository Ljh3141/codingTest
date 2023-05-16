public class Array3 {
    public int[] solution(Long n) {
        Long k = n;
        int count=0;
        
        while(k>0){
            k/=10l;
            count++;
        }
        System.out.println(n);
        int[] answer = new int[count];
        for(int i = 0; i<count; i++){
            Long a=n%10;
            answer[i] =a.intValue();
            System.out.println(answer[i]);
            n/=10l;
        }
        return answer;
    }
    
}
