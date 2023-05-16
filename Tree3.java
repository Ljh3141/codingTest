

import java.util.*;
class Tree3 {
    public int solution(int n, int[][] results) {
        //방향성 그래프 문제. 자신의 하위에 있는 모든 노드 수 및 자신의 위에 있는 모든 노드수 카운팅.
        Node[] nodes = new Node[n];
        for(int i = 0 ; i<n; i++)nodes[i] = new Node(i);
        for(int[] data : results){
            nodes[data[0]-1].addWin(nodes[data[1]-1]);//승리 추가
        }
        //데이터 추가 완료.
        
        for(Node data : nodes){//모든 노드에 대해서 탐색
            for(Node nd : nodes) nd.visited=false;//탐색 초기화
            Queue<Node> queue = new LinkedList<>();
            queue.offer(data);
            
            while(queue.size()>0){
                Node now = queue.poll();
                
                for(Node loser : now.losers){
                    if(loser.visited) continue;//이미 진것으로 체크한 노드는 체크하지 않음. 한 노드가 여러 노드에 졌을 때 중복 체크 방지
                    loser.visit();
                    
                    data.wins++;//현재 노드 기준으로 승리 수
                    loser.loses++;//현재 노드에게 해당 노드가 패배한 수
                    queue.offer(loser);//하위 탐색을 위해 추가
                }
            }
        }
        int answer = 0;
        for(Node data : nodes){
            if(data.wins+data.loses+1 == n) answer++;
        }
        return answer;
    }
    
    class Node{
        int num;
        int wins = 0;
        int loses = 0;
        boolean visited = false;
        List<Node> losers = new ArrayList<>();
    
        Node(int num){
            this.num = num;
        }
        
        void addWin(Node node){
            losers.add(node);
        }
        
        void visit(){
            visited = true;
        }
    }
}

/*
import java.util.*;
class Tree3 {
    public int solution(int n, int[][] results) {
        //순위가 명확한 선수들을 Queue에 넣고 위(이 선수한테 이김) 아래(이 선수한테 짐)을 탐색 해야함.
        //모든 순위가 명확한 선수들의 위아래를 탐색하면 파악 가능한 순위인 선수들이 모두 나옴.
        //순위 파악이 가능한 선수들은 연속적으로 나올 수 밖에 없다.
        Node[] nodes = new Node[n];
        for(int i = 0 ; i<n; i++)nodes[i] = new Node(i);
        for(int[] data : results){
            nodes[data[0]-1].addWin(nodes[data[1]-1]);//승리 추가
            nodes[data[1]-1].addLose(nodes[data[0]-1]);//패배 추가
        }
        //데이터 추가 완료.
        //1번 검색으로 충분함.
        
        int answer = 0;
        Stack<Node> stack = new Stack<>();
        //순위가 확정인 선수들 추출 및 Stack 에 추가
        for(Node data : nodes){
            if(data.wins+data.loses+1 == n) {
                data.lank();
                stack.push(data);
                System.out.println(data.num+1);
                answer++;
            }//자신+이긴 수+진 수=총 선수 수 -> 순위 확정.
        }
        
        while(stack.size()>0){
            Node data = stack.pop();
            if(data.visited) continue; //이미 위아래를 탐색한 선수면 넘어감.
            data.visit();
            
            //랭크가 확정된 선수 : 위아래 추가
            if(data.lank!= -1){
                for(Node winner : data.winners){
                    stack.push(winner);
                }
                for(Node loser : data.losers){
                    stack.push(loser);
                }
            }
            //랭크가 확정된 선수에게 졌고 랭크가 확정되면 -> 이사람에게 진 사람들 스택에 추가.
            boolean lanked = false;
            for(Node winner : data.winners){
                if(winner.lank!= -1){
                    if(winner.lank+data.wins+1 == n){
                        System.out.println("found"+(data.num+1));
                        data.lank();
                        answer++;
                        lanked = true;
                        for(Node loser : data.losers){
                            stack.push(loser);
                        }
                        break;//순위가 확정되면 해당 선수의 랭크 판정 중단.
                    }
                }
            }
            if(lanked) continue;
            //랭크가 확정된 선수에게 이겼고 랭크가 확정되면 -> 이사람에게 이긴 사람들 스택에 추가.
            for(Node loser : data.losers){
                if(loser.lank!=-1){
                    if(loser.lank+data.loses+1 == n ){
                        System.out.println("found"+(data.num+1)+" "+data.loses+" "+loser.lank);
                        data.lank();
                        answer++;
                        for(Node winner : data.winners){
                            stack.push(loser);
                        }
                        break;//순위가 확정되면 해당 선수의 랭크 판정 중단.
                    }
                }
            }
        }
        
        return answer;
    }
    
    class Node{
        int num;
        int lank;
        int wins;
        List<Node> losers;
        int loses;
        List<Node> winners;
        boolean visited;
    
        Node(int num){
            this.num = num;
            lank = -1;
            wins = 0;
            losers = new ArrayList<>();
            loses = 0;
            winners = new ArrayList<>();
            visited = false;
        }
        
        void addWin(Node node){
            losers.add(node);
            wins++;
        }
        
        void addLose(Node node){
            winners.add(node);
            loses++;
        }
        
        void lank(){
            lank = loses+1;
        }
        
        void visit(){
            visited = true;
        }
    }
} */