import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class prac11866 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            bw.write("<");
            String[] data = br.readLine().split(" ");
            int k = Integer.parseInt(data[0]);
            int n = Integer.parseInt(data[1]);
            ArrayList<Integer> arr= new ArrayList<>();
            for(int i=0; i<k; i++){
                arr.add(i+1);
            }
            int index=-1;
            for(int i=0; i<k; i++){
                index+=n;
                while(index>=arr.size()) {
                    index%=arr.size();
                }
                bw.write(String.valueOf(arr.get(index)));
                arr.remove(index--);
                if(arr.size()==0)bw.write(">");
                else bw.write(", ");
            }
            bw.flush();
            br.close();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
