import java.util.Scanner;
import java.util.StringTokenizer;
public class prac1546 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        double sum = 0;
        int max=0;
        StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine()," " );
        while(stringTokenizer.hasMoreTokens()){
            int a = Integer.parseInt(stringTokenizer.nextToken());
            sum+= a;
            if(max<a) max=a;
        }
        System.out.println((sum/max*100)/k);
    }
}
