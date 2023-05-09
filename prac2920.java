import java.util.Scanner;

public class prac2920 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int[] arr = new int[8];

        boolean isMixed=false;

        for(int i=0; i<8; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        if(arr[0]==1){
            for(int i=1;i<8; i++){
                if(arr[i]!=i+1){
                    isMixed=true;
                }
            }
            if(isMixed){
                System.out.println("mixed");
                return;
            }else{
                System.out.println("ascending");
                return;
            }
        }else{
            int k = 8;
            for(int i=0;i<8; i++){
                if(arr[i]!=k--){
                    isMixed=true;
                }
            }
            if(isMixed){
                System.out.println("mixed");
                return;
            }else{
                System.out.println("descending");
                return;
            }
        }
    }
}