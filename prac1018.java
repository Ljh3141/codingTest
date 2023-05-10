import java.util.Scanner;
public class prac1018 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.nextLine();
        char[][] arr = new char[x][];
        for(int i = 0; i<x; i++){
            char[] data = scanner.nextLine().toCharArray();
            arr[i] = data;
        }
        int xMax = x-8;
        int yMax = y-8;
        //답.
        char[][] board = 
            {{'B','W','B','W','B','W','B','W'}
            ,{'W','B','W','B','W','B','W','B'}
            ,{'B','W','B','W','B','W','B','W'}
            ,{'W','B','W','B','W','B','W','B'}
            ,{'B','W','B','W','B','W','B','W'}
            ,{'W','B','W','B','W','B','W','B'}
            ,{'B','W','B','W','B','W','B','W'}
            ,{'W','B','W','B','W','B','W','B'}};
        int minChange = 64;

        for(int x1 =0; x1<=xMax; x1++){
            for(int y1 = 0; y1<=yMax; y1++){
                //작업은 여기서.
                int count1 = 0;
                int count2 = 0;
                //보드 체크
                //1.W부터
                for(int x2 = 0; x2<8; x2++){
                    for(int y2=0; y2<8; y2++){
                        if(board[x2][y2]!=arr[x1+x2][y1+y2]) count1++;
                        else count2++;
                    }
                }
                if(count1>count2){
                    if(minChange>count2) minChange=count2;
                }else{
                    if(minChange>count1) minChange=count1;
                }
            }
        }
        System.out.println(minChange);
    }
}
