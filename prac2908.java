import java.util.Scanner;
public class prac2908 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sa = 0;
        int sb = 0;
        for(int i = 0; i<3; i++){
            sa *=10;
            sb *=10;
            sa += a%10;
            sb += b%10;
            a/=10;
            b/=10;
        }
        if(sa>sb)System.out.println(sa);
        else System.out.println(sb);
    }
}
