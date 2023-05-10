import java.util.Scanner;

public class prac9498 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String result;
        if(k>=90) result="A";
        else if(k<90 && k>=80) result = "B";
        else if(k<80 && k>=70) result = "C";
        else if(k<70 && k>=60) result = "D";
        else result = "F";
        System.out.println(result);
    }
}