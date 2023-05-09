import java.util.Scanner;

public class prac2675 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int caseRepeat = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        scanner.nextLine();
        for(int k = 0; k<caseRepeat; k++){
            String[] str = scanner.nextLine().split(" ");
            int repeat = Integer.parseInt(str[0]);
            char[] c = str[1].toCharArray();

            for(int i = 0; i<c.length; i++){
                for(int j = 0; j<repeat; j++){
                    sb.append(c[i]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
