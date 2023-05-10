import java.util.Scanner;

public class prac2798 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = scanner.nextInt();
        }
        int max = 0;
        for(int i=0; i<n-2;i++){
            for(int j=i+1; j<n-1;j++){
                for(int k=i+2; k<n; k++){
                    if(j==k)continue;
                    int now = num[i]+num[j]+num[k];
                    if(max<now&&now<=m) max=now;
                }
            }
        }
        System.out.println(max);
    }
}