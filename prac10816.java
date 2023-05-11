
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


class prac10816{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(tmp, 0) + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class prac10816 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            int k = Integer.parseInt(br.readLine());
            int[] kCard = new int[k];
            String[] kStr = br.readLine().split(" ");
            for(int i=0; i<k; i++){
                kCard[i]=Integer.parseInt(kStr[i]);
            }
            int m = Integer.parseInt(br.readLine());
            int[] mCard = new int[m];
            String[] mStr = br.readLine().split(" ");
            for(int i=0; i<m; i++){
                mCard[i]=Integer.parseInt(mStr[i]);
            }
            Arrays.sort(kCard);
            int[] result = new int[m];//결과 값
            //이진 탐색
            for(int i = 0; i<m ; i++){
                result[i] =biSearch(kCard, mCard[i], 0, k-1);
                
            }
            for(int i = 0; i<m-1 ; i++){
                wr.write(String.valueOf(result[i])+" ");
            }
            wr.write(String.valueOf(result[m-1]));
            wr.flush();
            wr.close();
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static int biSearch(int[] nArr, int target, int first, int last){
        int count = 0;
        while (first<=last){
            int mid = (first+last)/2;
            if(target==nArr[mid]){
                count++;
                int forward = mid;
                while(true){
                    forward--;
                    if(forward<0)break;
                    if(nArr[forward]!=target)break;
                    count++;
                }
                int backward = mid;
                while(true){
                    backward++;
                    if(backward>nArr.length-1)break;
                    if(nArr[backward]!=target)break;
                    count++;
                }
                return count;
            }else if(target<nArr[mid])last = mid-1;
            else if(target>nArr[mid])first = mid+1;
        }
        return 0;
    }
     */
    /*
    static int countNum(int[] nArr, int target, int index){
        int count = 1;
        int i = 0;
        boolean toFirst = true;
        boolean toLast = true;
        while(toFirst||toLast){
            i++;
            if(index-i>=0&&toFirst){
                //앞으로 탐색
                if(nArr[index-i]==target)count++;
                else toFirst=false;
            }else toFirst=false;
            
            if(index+i<nArr.length&&toLast){
                int k = nArr[index+i];
                //뒤로 탐색
                if(nArr[index+i]==target)count++;
                else toLast=false;
            }else toLast=false;
        }
        return count;
    } 
}*/
