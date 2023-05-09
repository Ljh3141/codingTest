import java.util.Scanner;

public class prac2562 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[9];
        int index = 0;
        int max = 0;
        for(int i =0; i<9; i++){
            num[i] = scanner.nextInt();
        }
        for(int i=0; i<9; i++){
            if(num[i]>max){
                index=i;
                max=num[i];
            }
        }
        System.out.println(max);
        System.out.println(index+1);
    }
}
