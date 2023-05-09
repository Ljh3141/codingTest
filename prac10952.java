import java.util.Scanner;

public class prac10952 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String str = scanner.nextLine();
            String[] strArr = str.split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            if(a==0 && b==0) break;
            System.out.println(a+b);
        }
    }
}
