import java.util.Scanner;

class prac1330{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        if(A==B){
            System.out.println("==");
        }else if(A>B){
            System.out.println(">");
        }else{
            System.out.println("<");
        }
    }
}
