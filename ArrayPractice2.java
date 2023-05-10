import java.util.*;

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