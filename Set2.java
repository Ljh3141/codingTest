import java.util.*;

class Set2 {
    public boolean solution(String[] words) {
        String pre = words[0];
        Set<String> data = new HashSet<>();
        data.add(words[0]);
        boolean answer = true;
        for(int i =1; i<words.length; i++){
            if(!data.add(words[i])){
                answer = false;
                break;
            }
            /*
            char[] preStr = pre.toCharArray();
            char[] thisStr = words[i].toCharArray();
            if(preStr[preStr.length-1]!=thisStr[0]){
                answer = false;
                break;
            } */
            if(pre.charAt(pre.length()-1)!=words[i].charAt(0)){
                answer = false;
                break;
            }
            pre = words[i];
        }
        return answer;
    }
}