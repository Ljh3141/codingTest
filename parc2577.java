import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int result = A*B*C;
        int[] arr = new int[10];
        while(result>0){
            arr[result%10]++;
            result= result/10;
        }
        for(int i = 0; i<10; i++){
            System.out.println(arr[i]);
        }
    }
}