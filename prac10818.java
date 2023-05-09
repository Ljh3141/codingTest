import java.util.Scanner;

public class prac10818 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int max = -1000000;
        int min = 1000000;

        String[] num = str.split(" ");
        for(int i = 0; i<count; i++){
            int next = Integer.parseInt(num[i]);
            if(next>max) max = next;
            if(next<min) min = next;
        }
        System.out.println(min+" "+max);
    }
}
