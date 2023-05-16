public class LinearSearch2 {
    
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        char[] ca = s.toCharArray();
        for(char c : ca){
            if(c=='P'||c=='p') p++;
            if(c=='Y'||c=='y') y++;
        }

        return p==y;
    }
}
