import java.util.Scanner;
import java.util.StringTokenizer;

public class prac1920 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] stn = scanner.nextLine().split(" ");
        
        int m = scanner.nextInt();
        scanner.nextLine();
        StringTokenizer stm = new StringTokenizer(scanner.nextLine()," ");
        while(stm.hasMoreTokens()){
            String now = stm.nextToken();
            boolean has = false;
            for(int i=0; i<n; i++){
                if(stn[i].equals(now)){
                    System.out.println(1);
                    has = true;
                    break;
                }
            }
            if(!has) System.out.println(0);
        } 
    }
}
