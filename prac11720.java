import java.util.Scanner;
public class prac11720 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String data = scanner.nextLine();
        String[] datas = data.split("");
        int result = 0;
        for(int i = 0; i<k;i++){
            result+=Integer.parseInt(datas[i]);
        }
        System.out.println(result);
    }
}
