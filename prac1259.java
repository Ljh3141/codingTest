import java.util.Scanner;
public class prac1259 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String data = scanner.nextLine();
            if(data.equals("0")) break;
            char[] arr = data.toCharArray();
            boolean isPelin = true;
            for(int i = 0; i<arr.length-1;i++){
                if(arr[i]!=arr[arr.length-i-1])isPelin = false;
            }
            if(isPelin)System.out.println("yes");
            else System.out.println("no");
        }
    }
}
