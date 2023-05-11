import java.util.Scanner;

public class prac10814 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] age = new int[k];
        String[] name = new String[k];
        for(int i = 0; i<k; i++){
            age[i] = scanner.nextInt();
            name[i] = scanner.next();
        }
        //데이터 정리 끝
        int [] sortAge = new int[k];
        String[] sortName = new String[k];
        boolean[] inserted = new boolean[k];
        int index=0;
        int minAge=201;
        for(int i=0; i<k;i++){
            index = -1;
            minAge=201;
            for(int j=0; j<k; j++){
                if(inserted[j])continue;
                if(minAge>age[j]){
                    index=j;
                    minAge=age[j];
                }
            }
            sortAge[i] = age[index];
            sortName[i] = name[index];
            inserted[index] = true;
        }

        for(int i=0; i<k;i++){
            System.out.println(sortAge[i]+" "+sortName[i]);
        }
    }
}
