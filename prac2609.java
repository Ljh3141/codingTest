import java.util.Scanner;

public class prac2609 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int max = 1;
        for(int i=1; i<=a; i++){
            if(a%i==0 && b%i==0)max=i;
        }
        int min = a*b/max;
        System.out.println(max+"\n"+min);
    }
}
