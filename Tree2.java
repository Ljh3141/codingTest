
import java.util.*;
class Tree2 {
    public int solution(int n, int[][] edge) {
        //그래프 탐색 문제.
        //모든 노드를 그린 다음, 탐색을 통해 각 노드에 레벨을 기입한다. 이때 레벨의 최대치를 별도 저장한다.
        //탐색이 끝난다음, 모든 노드를 순차 검색하며 최대치인 노드의 수를 센다.->가능하면 노드 기입시에 저장하는 것도 좋다.
        //모든 노드의 최단거리를 기입하기 위해, 각 노드는 최초 1번만 탐색한다.
        //그래프에서 순환을 제거하고 기입하니까 Tree인가?
        //Tree 레벨 구하기+해당 레벨의 잎노드 구하기라고 볼 수 있을 듯 하다.
        //노드가 2만개이므로 중복제거에 set을 사용하기 어렵다.
        Node[] nodes = new Node[n];//0부터 시작. 모든 노드의 이름은 n+1로 취급한다.
        for(int i = 0; i<n; i++) nodes[i] = new Node(i);
        for(int[] data : edge){ // 노드 연결
            nodes[data[0]-1].add(nodes[data[1]-1]);//연산 편의를 위해 -1씩 해준다. 이제 각 노드는 index에 맞는 노드와 연결된다.
            nodes[data[1]-1].add(nodes[data[0]-1]);
        }
        //데이터 삽입 종료
        Queue<Node> queue = new LinkedList<>();//가까운것부터 체크해야하므로, 넓이 우선 검색으로 한다.
        nodes[0].level = 0;//최초 레벨 지정
        queue.offer(nodes[0]); //1번 삽입.
        int max = 0; //최대거리
        int count = 0; //갯수
        while(queue.size()>0){
            Node node = queue.poll();
            if(node.visited)continue; //방문했다면 스킵
            node.visit();
            if(node.level>max) {
                max = node.level; // 최장거리 레벨 지정
                count = 0; // 카운트 초기화.
            }
            if(node.level==max) count++;
            
            for(Node nnode : node.list){
                nnode.setLevel(node.level+1); //다음 노드 레벨 지정
                
                queue.offer(nnode);
            }
        }
        return count;
    }
    class Node{
        int num;
        List<Node> list;
        boolean visited;
        int level;
        
        Node(int num){
            this.num = num;
            this.list = new ArrayList();
            this.visited = false;
            this.level = -1;
        }
        
        void visit(){
            this.visited = true;
        }
        
        void add(Node i){
            list.add(i);
        }
        
        void setLevel(int i){
            if(this.level == -1) this.level = i;//최초 노드 지정 외에 노드 레벨이 수정되지 않도록 한다.
        }
    }
}
