
import java.util.*;
class Sort2 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new MyComp(n));
        
        return strings;
    }
}

class MyComp implements Comparator<String>{
    int n;
    public MyComp(int n ){
        this.n = n;
    }
    @Override
    public int compare(String obj1, String obj2){
        char c1 = obj1.charAt(n);
        char c2 = obj2.charAt(n);
        if(c1 == c2) return obj1.compareTo(obj2);
        return (int)c1-(int)c2;
    }
}
/*
class Solution{
    public String[] solution(String[] strings){
        Arrays.sort(strings, (s1, s2)->{
            if(s1.charAt(n) == s2.charAt(n))return s1.compareTo(s2);
            return s1.charAt(n) - s2.charAt(n);
        });
        return strings;
    }
}

 */
