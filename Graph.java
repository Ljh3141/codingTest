import java.util.*;
class Graph {
    public int solution(int n, int[][] wires) {
        //모든 라인을 끊어보면서 차이를 세기
        //최대 차이 n-2개, n개를 기본값으로
        int min = n;
        Node[] nodes = new Node[n];
        for(int i = 0; i<n ; i++) nodes[i] = new Node();
        for(int[] data : wires){//링크 연결
            nodes[data[0]-1].link.add(nodes[data[1]-1]);
            nodes[data[1]-1].link.add(nodes[data[0]-1]);
        }
        for(int[] data : wires){//하나씩 끊어보기
            nodes[data[1]-1].visit();//끊음
            Stack<Node> stack = new Stack<>();
            stack.push(nodes[data[0]-1]);
            int count = 0;
            while(stack.size()>0){
                Node node = stack.pop();
                if(node.visited) continue; //방문했던 곳.
                node.visit();
                count++;
                for(Node next : node.link){
                    stack.push(next);
                }
            }
            if(Math.abs(n-2*count)<min) min = Math.abs(n-2*count);
            //순회가 끝나면 데이터 초기화 필요
            for(Node nd : nodes) nd.visited = false;
        }
        
        int answer = min;
        return answer;
    }
    class Node{
        boolean visited = false;
        ArrayList<Node> link = new ArrayList<>();
        
        void visit(){
            visited = true;
        }
    }
}
