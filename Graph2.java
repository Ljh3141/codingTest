
class Graph2 {
    public int solution(int[] numbers, int target) {
        //전이진 트리 구조 문제.
        //n자리수 2진법의 0부터 최대값까지 활용 할 수 있나?
        System.out.println(Math.pow(2,numbers.length));
        int count=0;
        for(int i = 0; i<Math.pow(2,numbers.length) ; i++){
            int calc = i;
            int sum = 0;
            for(int j = 0; j<numbers.length; j++){
                int pos = calc%2;
                if(pos==0){
                    sum+=numbers[j];
                }else{
                    sum-=numbers[j];
                }
                calc/=2;
            }
            if(sum==target)count++; 
        }
        int answer = count;
        return answer;
    }
}