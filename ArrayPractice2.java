import java.util.*;
class ArrayPractice2 {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Car> cars = new HashMap<>();
        for(String data : records){
            String[] datas = data.split(" ");
            int carNum = Integer.parseInt(datas[1]);
            if(!cars.containsKey(carNum)){
                cars.put(carNum, new Car());//해당 번호의 차가 없으면 추가.
            }
            Car car = cars.get(carNum);
            //입차이면 시간 등록
            String[] time = datas[0].split(":");
            if(datas[2].equals("IN")){
                String[] times = datas[0].split(":");
                car.park(Integer.parseInt(times[0])*60+Integer.parseInt(times[1]));
            }
            //출차는 시간 계산
            else{
                String[] times = datas[0].split(":");
                car.calcTime(Integer.parseInt(times[0])*60+Integer.parseInt(times[1]));
            }
        }
        for(int carNum : cars.keySet()){
            Car car = cars.get(carNum);
            if(car.parked){
                //자정에도 주차중
                car.calcTime(23*60+59);
            }
        }
        Integer[] carNums = cars.keySet().toArray(new Integer[0]);
        Arrays.sort(carNums);//차 번호 정렬
        //요금 계산
        int[] answer = new int[carNums.length];
        for(int i = 0; i < carNums.length; i++){
            answer[i] = calcFee(fees, cars.get(carNums[i]));
        }
               
        return answer;
    }
    

    class Car{
        int time;
        int inTime;
        boolean parked;
        Car(){
            this.time = 0;
        }
        void calcTime(int t){
            time += t-inTime;
            parked = false;
        }
        
        void park(int t){
            inTime = t;
            parked = true;
        }
    }
    
    static int calcFee(int[] fees, Car car){
        //요금 계산
        int time  = car.time;
        if(time<=fees[0]) return fees[1];
        else{
            //기본요금+단위 요금*((시간-기본시간/단위 시간)의 올림)
            return fees[1]+fees[3]*(int)Math.ceil((time-fees[0])/(float)fees[2]);
        }
    }
}
/*import java.util.*;

class ArrayPractice2 {
        
    static class Info {

        String carNumber;
        String curTime;
        boolean isIn;

        int sumTime;

        Info(String time, String carNumber, boolean isIn) {
            this.curTime = time;
            this.carNumber = carNumber;
            this.isIn = isIn;
        }

        public void calc(String other) {
            StringTokenizer st = new StringTokenizer(this.curTime, ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());

            int prev = hour * 60 + min;

            st = new StringTokenizer(other, ":");
            hour = Integer.parseInt(st.nextToken());
            min = Integer.parseInt(st.nextToken());
        
            sumTime += (hour*60 + min) - prev;
        }

//        @Override
//        public boolean equals(Object other) {
//
//            Info o = (Info)other;
//            return this.carNumber == o.carNumber;
//        }
    }

    public int[] solution(int[] fees, String[] records) {

        Map<String, Info> map = new HashMap<>();
        List<String> carNumbers = new ArrayList<>();

        for(String a : records) {
            StringTokenizer st = new StringTokenizer(a);
            String time = st.nextToken();
            String carNumber = st.nextToken();
            String breakdown = st.nextToken();

            if (breakdown.equals("IN")) {
                
                if(!carNumbers.contains(carNumber)) {
                    carNumbers.add(carNumber); 
                    map.put(carNumber, new Info(time, carNumber, true));
                    continue;
                }
                
                Info cur = map.get(carNumber);
                cur.curTime = time;
                cur.isIn = true;
                
            } else {
                Info info = map.get(carNumber);
                info.calc(time);
                info.isIn = false;
            }
        }

        Collections.sort(carNumbers);
        int[] result = new int[carNumbers.size()];
        int idx = 0;
        for (String s : carNumbers) {
            Info info = map.get(s);
            if(info.isIn) {
                info.calc("23:59");
            }
            
            
            result[idx] = info.sumTime <= fees[0] ? fees[1]
                    : fees[1] + (int)Math.ceil((info.sumTime - fees[0])/(double)fees[2]) * fees[3];
            idx++;
        }
        return result;
    }
}
*/