import java.util.Scanner;

public class prac10951 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            String str = scanner.nextLine();
            String[] strArr = str.split(" ");
            System.out.println(Integer.parseInt(strArr[0])+Integer.parseInt(strArr[1]));
        }
    }
}
