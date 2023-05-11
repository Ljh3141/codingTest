import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prac1920 {
    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n ; i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<m ; i++){
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);
        //2진 탐색
        for(int i = 0; i <m ; i++){
            int first = 0; 
            int last = n-1;
            boolean exist = false;
            while (first<=last){
                int mid = (first+last)/2;
                if(mArr[i]==nArr[mid]){
                    exist = true;
                    break;
                }else if(mArr[i]<nArr[mid])last = mid-1;
                else if(mArr[i]>nArr[mid])first = mid+1;
            }
            if(exist) bw.write("1\n");
            else bw.write("0\n");
        }
        bw.flush();

    }
}

/*
//timeout
import java.util.Scanner;
import java.util.StringTokenizer;

public class prac1920 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] stn = scanner.nextLine().split(" ");
        
        int m = scanner.nextInt();
        scanner.nextLine();
        StringTokenizer stm = new StringTokenizer(scanner.nextLine()," ");
        while(stm.hasMoreTokens()){
            String now = stm.nextToken();
            boolean has = false;
            for(int i=0; i<n; i++){
                if(stn[i].equals(now)){
                    System.out.println(1);
                    has = true;
                    break;
                }
            }
            if(!has) System.out.println(0);
        } 
    }
}
 */