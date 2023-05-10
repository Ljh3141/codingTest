import java.util.Scanner;
public class prac3052 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] last = new int[42];
        for(int i = 0; i<10; i++){
            last[scanner.nextInt()%42]++;
        }
        int count=0;
        for(int i = 0; i<42; i++){
            if(last[i]!=0) count++;
        }
        System.out.println(count);
    }
}
