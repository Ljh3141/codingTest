import java.util.*;
class Graph3
 {
    public int solution(String begin, String target, String[] words) {
        //강의 코드 반례 : "hit", "cog", ["hot", "dot", "hog", "dog", "lot", "log", "cog"], 3
        //hit->hot->hog->cog 3단계여야하나 4단계가 나옴.
        //강의 코드에서는 처음 target이 나오는 depth를 검색하는 것으로 보임. target을 발견하는 즉시 반환
        //target을 발견하는 경우, 해당 depth이하에서 target이 다시 검색되는지 확인해야함.
        if(!Arrays.asList(words).contains(target)) return 0;
        Stack<Word> stack = new Stack<>();
        Set<String> used = new HashSet<>();
        
        stack.push(new Word(begin, 0));
        int max= words.length+1;//초과 레벨 수
        String preStr=""; //이전 단어. 검색을 줄일 목적.
        
        while(!stack.isEmpty()){
            Word now = stack.pop();
            used.remove(now.name);//이번 문자를 사용됨에서 제거함, 제거하지 않는경우, 다음번 다른 경로에서 문제가 됨.
            if(now.depth>max)continue; //레벨이 초과인경우, 해당 경로를 제외
            System.out.println(now.name+":"+now.depth);
            if(now.name.equals(target)){
                if(max>now.depth) max=now.depth;
            }else{
                for(String s : words){
                    if(!isConnect(now.name, s)) continue;
                    if(used.contains(s))continue;
                    if(preStr.equals(s))continue;
                    used.add(s);
                    stack.push(new Word(s, now.depth+1));
                }
            }
            preStr=now.name;
        }
        
        //경로가 검출되지 않음.
        if(max ==words.length+1){
            return 0;
        }
        int answer = max;
        return answer;
    }
    boolean isConnect(String s1, String s2){
        int count = 0;
        for(int i = 0; i<s1.length()&&count<2; i++){
            if(s1.charAt(i)!=s2.charAt(i))count++;
        }
        return count == 1;
    }
    
    class Word{
        String name;
        int depth;
        public Word(String name, int depth){
            this.name = name;
            this.depth = depth;
        }
    }
}