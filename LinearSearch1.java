
import java.util.*;

class LinearSearch1 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 1; i<phone_book.length; i++){
            if(phone_book[i].startsWith(phone_book[i-1]))return false;
        }
        
        boolean answer = true;
        return answer;
    }
}
/*class LinearSearch1 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i<phone_book.length;i++){
            char[] c = phone_book[i].toCharArray();
            for(int j = 0; j<phone_book.length; j++){
                if(i==j) continue;
                char[] s = phone_book[j].toCharArray();
                if(c.length>s.length)continue;
                boolean prefix=true;
                //자기자신 아님. 비교대상이 자신보다 큼.
                for(int k = 0; k<c.length; k++){
                    if(c[k]!=s[k]){
                        prefix=false;
                        break;
                    }
                }
                if(prefix)return false;
            }
        }
        return answer;
    }
}
*/