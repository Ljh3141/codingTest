import java.util.Scanner;
public class prac2439 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int space = a;
        for(int i = 0; i<a; i++){
            for(int j = 0; j<a; j++){
                if(j<space-1) System.out.print(" ");
                else System.out.print("*");
            }
            space--;
            System.out.println();
        }
    }
}
