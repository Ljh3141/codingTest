import java.util.Scanner;

public class prac9012 {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<k; i++){
            char[] c = scanner.nextLine().toCharArray();
            int level = 0;
            boolean coruppted = false;
            for(char ch : c){
                if(ch=='(') level++;
                else level--;
                if(level<0) coruppted=true;
                
                System.out.println(ch+":"+level);
            }
            if(level==0 && !coruppted)System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
