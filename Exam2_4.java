
import java.util.*;
class Exam2_4 {
    public int solution(int n, int m, int[][] hole) {
        //아마도 그래프 탐색 문제
        int[][] map = new int[n][m];
        int[][][] data = new int[n][m][2];
        for(int[][] i : data){
            for(int[] j : i){
                j[0] = -1;
                j[1] = -1;
            }
        }
        for(int[] l : hole){
            map[l[0]-1][l[1]-1]=1;
        }
        //데이터 초기화 완료
        //주어져야 하는 데이터 : x, y, 신발 사용수
        Queue<Locate> queue = new LinkedList<>();
        queue.offer(new Locate(0,0,0,0));
        while(queue.size()>0){
            Locate locate = queue.poll();
            //위치 이탈 또는 구멍으로 이동
            if(locate.x<0 || locate.x>=n || locate.y<0||locate.y>=m||map[locate.x][locate.y]==1)continue;
            if(data[locate.x][locate.y][locate.s]!=-1)continue;//왔던곳.
            data[locate.x][locate.y][locate.s] = locate.step;//위치 기록
            //상하좌우
            queue.offer(new Locate(locate.x+1, locate.y, locate.s, locate.step+1));
            queue.offer(new Locate(locate.x-1, locate.y, locate.s, locate.step+1));
            queue.offer(new Locate(locate.x, locate.y+1, locate.s, locate.step+1));
            queue.offer(new Locate(locate.x, locate.y-1, locate.s, locate.step+1));
            //신발을 안썼다면 쓴것도 고려.
            if(locate.s == 0){
                queue.offer(new Locate(locate.x+2, locate.y, 1, locate.step+1));
                queue.offer(new Locate(locate.x-2, locate.y, 1, locate.step+1));
                queue.offer(new Locate(locate.x, locate.y+2, 1, locate.step+1));
                queue.offer(new Locate(locate.x, locate.y-2, 1, locate.step+1));
            }
            
        }
        int answer = -1;
        if(data[n-1][m-1][0]==-1 &&data[n-1][m-1][1]==-1)return -1; // 도달에 실패
        else if(data[n-1][m-1][0]==-1) answer = data[n-1][m-1][1];//모든 경로가 한칸 끊어진 경우->신발 안쓰면 도달 불가
        else if(data[n-1][m-1][1]==-1) answer = data[n-1][m-1][0];//길이 지그재그인 경우->신발 쓰면 도달 불가
        else answer = data[n-1][m-1][0]>data[n-1][m-1][1]?data[n-1][m-1][1]:data[n-1][m-1][0];
        return answer;
    }
    class Locate{
        int x;
        int y;
        int s;
        int step;
        Locate(int x, int y, int s, int step){
            this.x = x;
            this.y = y;
            this.s = s;
            this.step = step;
        }
    }
}