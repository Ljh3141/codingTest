import java.util.Scanner;
import java.util.StringTokenizer;
public class prac10871 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int max = scanner.nextInt();
        int[] arr = new int[k];
        int count = 0;
        scanner.nextLine();
        StringTokenizer st = new StringTokenizer(scanner.nextLine()," ");
        while(st.hasMoreTokens()){
            int now = Integer.parseInt(st.nextToken());
            if(now<max)arr[count++]=now;
        }
        for(int i = 0; i<count; i++){
            if(i!=0)System.out.print(" ");
            System.out.print(arr[i]);
        }
    }
}
