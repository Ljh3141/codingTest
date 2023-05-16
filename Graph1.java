
import java.util.*;
class Graph1 {
    public int solution(int n, int[][] computers) {
        //노드를 순회하고, 순회를 마치면 순회하지 않은 노드를 찾아 순회하고를 반복. 순회를 마칠 때마다 count를 1씩 증가.
        Node[] nodes = new Node[n];
        Stack<Node> stack = new Stack<Node>();
        for(int i = 0; i<n; i++){
            nodes[i]= new Node(i);
            
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i==j)continue;
                if(computers[i][j]==1)nodes[i].add(nodes[j]);
            }
        }
        int answer=0;
        //데이터 삽입 종료
        int next = isLeft(nodes, n);
        while(next>-1){
            stack.push(nodes[next]);//최초값 삽입.
            while(stack.size()>0){
                Node nd = stack.pop();
                nd.visit();
                for(Node na : nd.list){
                    if(na.isVisited()) continue;
                    stack.push(na);
                }
            }
            next = isLeft(nodes, n);
            answer++;
        }
        
        
        return answer;
    }
    static int isLeft(Node[] nodes, int n){
        for(int i = 0; i<n ; i++){
            if(!nodes[i].visited) return i;
        }
        return -1;
    }
}

class Node{
    public int self;
    public List<Node> list;
    boolean visited;
    
    public Node(int self){
        this.self = self;
        this.list = new ArrayList<>();
        visited = false;
    }
    
    public void add(Node i){
        list.add(i);
    }
    
    public void visit(){
        visited = true;
    }
    
    public boolean isVisited(){
        return visited;
    }
}