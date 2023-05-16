
import java.util.*;
class Graph4 {
    class Location{
        int x;
        int y;
        Location(int x, int y){
            this.x = x;
            this.y = y;
        }
        boolean equals(Location l){
            return x==l.x&&y==l.y;
        }
        Location left(){return new Location(x-1, y);}
        Location right(){return new Location(x+1, y);}
        Location up(){return new Location(x, y-1);}
        Location down(){return new Location(x, y+1);}
    }
    class Position{
        int steps;
        Location location;
        Position(Location l, int s){
            location = l;
            steps = s;
        }
    }
    public int solution(int[][] maps) {
        final int mapSizeX = maps.length;
        final int mapSizeY = maps[0].length;
        final Location target = new Location(mapSizeX-1, mapSizeY-1);
        
        boolean[][] visited = new boolean[mapSizeX][mapSizeY];
        
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(new Location(0,0),1));
        while(!queue.isEmpty()){
            Position now = queue.poll();
            
            if(now.location.x<0) continue;
            if(now.location.x>=mapSizeX) continue;
            if(now.location.y<0) continue;
            if(now.location.y>=mapSizeY) continue;
            if(maps[now.location.x][now.location.y]==0) continue;
            if(visited[now.location.x][now.location.y]) continue;
            
            visited[now.location.x][now.location.y] = true;//경로를 반드시 한번에 찾게 된다. 이 코드 뭔가 반드시 반례가 있다. 나중에 다시 찾아보기.
            
            if(now.location.equals(target)){
                return now.steps;
            }
            
            queue.offer(new Position(now.location.left(), now.steps+1));
            queue.offer(new Position(now.location.right(), now.steps+1));
            queue.offer(new Position(now.location.up(), now.steps+1));
            queue.offer(new Position(now.location.down(), now.steps+1));
        }
        return -1;
    }
}
