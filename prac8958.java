import java.util.Scanner;

public class prac8958 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        int[] result = new int[k];

        for(int i=0; i<k; i++){
            int score = 0;
            int count = 0;
            char[] c = scanner.nextLine().toCharArray();
            for(int j = 0; j<c.length; j++){
                if(c[j]=='O'){
                    count++;
                    score+=count;
                }else{
                    count = 0;
                }
            }
            result[i] = score;
        }
        for(int i=0; i<k; i++){
            System.out.println(result[i]);
        }
    }
}
