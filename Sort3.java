
class ort3 {
    public String solution(String s) {
        String sc = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char[] c = sc.toCharArray();
        if(c[0]>='a' && c[0]<='z') c[0]-=32;
        sb.append(c[0]);
        
        boolean isBlank = false;
        for(int i = 1; i<c.length; i++){
            char f = c[i];
            if(isBlank){
                if(f>='a' && f<='z') f-=32;
            }
            if(f==' ')isBlank=true;
            else isBlank=false;
            sb.append(f);
        }
        String answer = sb.toString();
        return answer;
    }
}
/*

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String s2 = s.toLowerCase();
        char last = ' ';
        for(char c : s2.toCharArray()){
            if(last == ' ') c=Character.toUpperCase(c);;
            sb.append(c);
            last = c;
        }
        return sb.toString();
    }
 */