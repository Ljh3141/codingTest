import java.util.*;
class Solution {
    public static void main(String[] args){
        int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        //DFS 문제
        //k에서 n개를 뽑지만 순서가 상관있음.
        ch = new boolean[ability.length];
        pick(0, 0, ability);
        
        System.out.println(max);
    }
    static int max=0;
    static boolean[] ch;
    static public void pick(int level, int sum, int[][] ab){
        if(level == ab[0].length){
            //전부 뽑음.
            if(max<sum)max=sum;
            return;
        }
        for(int i = 0; i<ab.length; i++){
            if(!ch[i]){
                //뽑히지 않은것만 다음 레벨로
                ch[i]=true;
                pick(level+1, sum+ab[i][level], ab);
                ch[i]=false;
            }
        }
    }
        
}
/*
import java.util.*;
class Exam1_2  {
    public int solution(int[][] ability) {
        //DFS 문제
        //k에서 n개를 뽑지만 순서가 상관있음.
        int n = ability.length;
        int k = ability[0].length;
        Integer[] arr =new Integer[k];
        int max=0;
        List<Integer> list =Arrays.asList(arr);
        int level = 0;
        for(int i = 0; i<ability.length; i++){
            Stack<Student> stack = new Stack<Student>();
            stack.push(new Student(i,1));
            list.set(0, i);//첫번째 종목에 i번째 학생을 넣음
            while(stack.size()>0){
                Student now = stack.pop();
                for(int a = now.level-1; a<k+1; a++)list.set(a-1, -1);
                if(list.contains(now.num)) continue;//이미 선발된 학생
                list.set(now.level, now.num);
                if(now.level==k+1){
                    //다 뽑았음.
                    //계산 절차
                    int result=0;
                    for(int t= 0; t<k; t++){
                        result+=ability[list.get(t)][t];
                    }
                    if(result>max){
                        max = result;
                    }
                }else{
                    for(int j = 0; j<n ; j++){
                        stack.push(new Student(j, now.level+1));
                    }
                }
            }
        }
        return max;
    }
    class Student{
        int num, level;
        Student(int num, int level){
            this.num = num;
            this.level = level;
        }
    }
        
}*/