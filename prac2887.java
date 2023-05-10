import java.util.Scanner;
public class prac2887 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int time = a*60+b-45;
        if(time<0)time+=24*60;
        System.out.println(time/60+" "+time%60);
    }
}
