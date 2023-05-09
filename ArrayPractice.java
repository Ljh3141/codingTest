public class ArrayPractice {
    
    public int[] solution(int[] fees, String[] records) {
        int[] inTimeArray = new int[10000];
        int[] sumTimeArray = new int[10000];
        boolean[] carIn = new boolean[10000];
        for(int i = 0; i<records.length; i++){
            String[] data = records[i].split(" ");
            String[] times = data[0].split(":");
            int time = Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
            int number = Integer.parseInt(data[1]);
            if(data[2].equals("IN")){
                //입차
                inTimeArray[number] = time;
                carIn[number] = true;
            }else{
                //출차
                sumTimeArray[number] += time - inTimeArray[number];
                carIn[number] = false;
            }
        }
        int count = 0;
        for(int i=0; i<10000; i++){
            if(carIn[i]){
                sumTimeArray[i] += (23*60+59)-inTimeArray[i];
            }
            if(sumTimeArray[i]!=0) {
                count++;
            }
        }
        //데이터 처리 끝
        int[] answer = new int[count];
        count = 0;
        for(int i=0; i<10000; i++){
            if(sumTimeArray[i]>0){
                int fee = 0;
                if(sumTimeArray[i] <= fees[0]) fee = fees[1];
                else{
                    fee = fees[1]+ ((sumTimeArray[i]-fees[0])/fees[2])*fees[3];
                    if(sumTimeArray[i]%fees[2]>0) fee += fees[3];
                }
                answer[count] = fee;
                count++;
            }
        }
        
        return answer;
    }
}
