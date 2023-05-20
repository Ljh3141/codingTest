
class Exam1_3 {
    public String[] solution(int[][] queries) {
        //true == R, false == r;
        
        String[] answer = new String[queries.length];
        for(int i = 0; i<queries.length; i++){
            boolean[] init = {true, false};
            boolean[] result = next(queries[i][0], queries[i][1], init);
            StringBuilder sb = new StringBuilder();
            if(result[0]) sb.append("R");
            else sb.append("r");
            if(result[1]) sb.append("R");
            else sb.append("r");
            answer[i] = sb.toString();
        }
        return answer;
    }
    boolean[] next(int gen, int to, boolean[] Rr){
        if(Rr[0]==Rr[1])return Rr;//RR또는 rr아래서는 RR또는 rr만 나오므로 즉시 반환
        if(gen == 1)return Rr;
        int i = (to-1)/(int)Math.pow(4, gen-2);
        i=i%4;
        boolean a =false;
        boolean b =false;
        switch(i){
            case 0:
                a = Rr[0];
                b = Rr[0];
                break;
            case 1:
                a = Rr[0];
                b = Rr[1];
                break;
            case 2:
                a = Rr[0];
                b = Rr[1];
                break;
            case 3:
                a = Rr[1];
                b = Rr[1];
                break;
        }
        Rr[0] = a;
        Rr[1] = b;
        return next(gen-1, to, Rr);
    }
}