import java.util.Scanner;

public class prac10250 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for(int i = 0; i<k ; i++){
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int count = scanner.nextInt();
            int roomNum = (count-1)/h+1 + ((count-1)%h+1)*100;
            System.out.println(roomNum);
        }
    }
}
