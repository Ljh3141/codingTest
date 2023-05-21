
class Exam2_1 {
    public int[] solution(String command) {
        char[] orders = command.toCharArray();
        Robot robot = new Robot();
        for(char c : orders){
            robot.order(c);
        }
        int[] answer = {robot.x, robot.y};
        return answer;
    }
    class Robot{
        //방향은 0,1,2,3 을 가진다.
        //12, 3, 6, 9 방향이다.
        int heading = 0;
        int x = 0;
        int y = 0;
        void order(char c){
            switch(c){
                case 'R':
                    heading++;
                    if(heading>3) heading = 0;
                    break;
                case 'L':
                    heading--;
                    if(heading<0)heading = 3;
                    break;
                case 'G':
                    switch(heading){
                        case 0:
                            y++;
                            break;
                        case 1:
                            x++;
                            break;
                        case 2:
                            y--;
                            break;
                        case 3:
                            x--;
                            break;
                    }
                    break;
                case 'B':
                    switch(heading){
                        case 0:
                            y--;
                            break;
                        case 1:
                            x--;
                            break;
                        case 2:
                            y++;
                            break;
                        case 3:
                            x++;
                            break;
                    }
                    break;
            }
        }
    }
}