import java.util.Scanner;
import java.math.*;
public class prac2475 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int result = 0;
        for(int i = 0 ; i<5; i++){
            result += (int)Math.pow(Integer.parseInt(data[i]),2);
        }
        System.out.println(result%10);
    }
}
