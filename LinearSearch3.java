
import java.util.*;
class LinearSearch3  {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s : skill_trees){
            String s2 = s.replaceAll("[^"+skill+"]", "");
            if(skill.startsWith(s2))answer++;
        }

        return answer;
    }
    /*
    public int solution(String skill, String[] skill_trees) {
        char[] skc = skill.toCharArray();
        int top = skc.length;
        int count = 0;
        
        List<Integer> data = new ArrayList<>();
        for(char c :skc){
            data.add((int)c);
        }
        
        
        for(String s : skill_trees){
            int level = 0;
            char[] stc = s.toCharArray();
            boolean possible = true;
            for(int i=0; i<stc.length; i++){
                int index = data.indexOf((int)stc[i]);
                if(index==-1)continue;
                else if(index>level){
                    possible=false;
                    break;
                }else{
                    level++;
                }
            }
            if(possible)count++;
        }
        int answer = count;
        return answer;
    } */
}