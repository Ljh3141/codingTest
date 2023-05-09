import java.util.Scanner;

public class prac2739 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for(int i=1; i<10; i++){
            System.out.println(k+" * "+ i +" = "+ i*k);
        }
    }
}
