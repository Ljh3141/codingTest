import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class prac1181 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String[] data = new String[k];
        scanner.nextLine();
        for(int i = 0; i<k; i++){
            data[i]=scanner.nextLine();
        }

        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2){
                if(str1.length()==str2.length()){
                    return str1.compareTo(str2);
                }else{
                    return str1.length()-str2.length();
                }
            }
            
        });
        //출력
        for(int i = 0; i<k; i++){
            if(i==0) System.out.println(data[i]);
            else{
                if(!data[i].equals(data[i-1])) System.out.println(data[i]);
            }
        }
    }
}
