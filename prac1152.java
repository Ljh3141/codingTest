import java.util.Scanner;

class prac1152{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int count = 0;
        for(String data : str){
            if(data.isEmpty()) continue;
            else count++;
        }
        System.out.println(count);
    }
}