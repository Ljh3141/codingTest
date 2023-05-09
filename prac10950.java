import java.util.Scanner;
public class prac10950 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<k; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);
        }
    }
}
