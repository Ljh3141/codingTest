import java.util.Scanner;
public class prac1157 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] c = scanner.nextLine().toUpperCase().toCharArray();
        int[] result = new int[26];
        for(int i = 0; i<c.length; i++){
            result[c[i]-'A']++;
        }
        int big = 0;
        int maxCount=0;
        boolean duplicate=false;
        for(int i=0; i<26; i++){
            if(maxCount<result[i]){
                big = i;
                maxCount = result[i];
                duplicate =false;
            }else if(maxCount==result[i]){
                duplicate=true;
            }
        }
        if(duplicate){
            System.out.println("?");
        }else{
            System.out.printf("%c", big+'A');
        }
    }
    
}
