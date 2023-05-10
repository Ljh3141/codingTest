import java.util.Scanner;
public class prac2753 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        if( (k%4==0 && k%100!=0) || k%400==0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
