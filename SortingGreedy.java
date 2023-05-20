
import java.util.*;
class SortingGreedy {
    public int solution(int[][] routes) {
        //출구 지점으로 정렬한다.
        //첫 출차점을 찾고, 카메라를 설치하고, 포함되는 차를 찾고, 카메라가 없으면 다음차를 찾고..를 반복한다.
        //정렬을 어떻게 하지.
        Car[] cars = new Car[routes.length];
        for(int i = 0; i<routes.length; i++){
            cars[i] = new Car(routes[i][0],routes[i][1]);
        }
        Arrays.sort(cars);//출구, 오름차순 정렬됨.
        int cams = 0; //카메라수
        int camLocate = -30001; //카메라의 현재 위치
        for(int i = 0; i<cars.length; i++){
            //카메라 위치보다 enter가 앞이면 이번 차량은 체크됨. 넘어감
            if(camLocate>=cars[i].in)continue;
            //카메라 위치보다 enter가 뒤면 새 카메라를 설치해야함.
            else{
                camLocate = cars[i].out;
                cams++;
            }
        }
        
        return cams;
    }
    class Car implements Comparable<Car>{
        int in;
        int out;
        Car(int i, int o){
            in = i; out = o;
        }
        @Override
        public int compareTo(Car c){
            return out-c.out;
        }
    }
}
/*
 import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        //출구 지점으로 정렬한다.
        //첫 출차점을 찾고, 카메라를 설치하고, 포함되는 차를 찾고, 카메라가 없으면 다음차를 찾고..를 반복한다.
        //정렬을 어떻게 하지.
        Arrays.sort(routes, (o1, o2)->{
            return o1[1]-o2[1];
        });//출구, 오름차순 정렬됨.
        int cams = 0; //카메라수
        int camLocate = -30001; //카메라의 현재 위치
        for(int i = 0; i<routes.length; i++){
            //카메라 위치보다 enter가 앞이면 이번 차량은 체크됨. 넘어감
            if(camLocate>=routes[i][0])continue;
            //카메라 위치보다 enter가 뒤면 새 카메라를 설치해야함.
            else{
                camLocate = routes[i][1];
                cams++;
            }
        }
        
        return cams;
    }
}//비교문 축약 버전.
 */