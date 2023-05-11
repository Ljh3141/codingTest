import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class prac2164 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Queue<Integer> iq = new LinkedList<>();
        for(int i=0; i<k; i++){
            iq.add(i+1);
        }
        while(iq.size()!=1){
            iq.poll();
            iq.add(iq.poll());
        }
        System.out.println(iq.poll());
    }    
}
