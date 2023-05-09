import java.util.Scanner;

class prac1008{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        double A = Double.parseDouble(arr[0]);
        double B = Double.parseDouble(arr[1]);
        System.out.println(A/B);
    }
}