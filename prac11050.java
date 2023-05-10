import java.util.Scanner;

public class prac11050 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result =1;
        for(int i = 0; i<b; i++){
            result*=(a-i);
        }
        for(int i = b; i>0; i--)result/=i;
        System.out.println(result);
    }
    
}
