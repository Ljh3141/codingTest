import java.util.Scanner;

public class prac1978 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] num = new int[k];
        for(int i = 0; i<k; i++){
            num[i]=scanner.nextInt();
        }
        int count=0;
        for(int n : num){
            if(n==1)continue;
            int max = n/2;
            int a = 1;
            boolean isPrime = true;
            while(a<max){
                a++;
                if(n%a==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)count++;
        }
        System.out.println(count);
    }
}
