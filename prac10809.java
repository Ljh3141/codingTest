import java.util.Scanner;
public class prac10809 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] c = scanner.nextLine().toCharArray();
        int[] arr = new int[26];
        for(int i = 0; i<26; i++){
            arr[i] = -1;
        }
        for(int i = 0; i<c.length; i++){
            if(arr[c[i]-'a']==-1) arr[c[i]-'a']=i;
        }
        for(int i=0; i<26; i++){
            if(i!= 0)System.out.print(" ");
            System.out.print(arr[i]);
        }
    }
    
}
