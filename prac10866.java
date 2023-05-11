
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class prac10866 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            int k = Integer.parseInt(br.readLine());
            int[] queue = new int[k];
            int top = -1;
            for(int i = 0; i<k; i++){
                String[] data = br.readLine().split(" ");
                switch(data[0]){
                    case "push_front":
                        for(int j = top+1; j>0; j--){
                            queue[j] = queue[j-1];
                        }
                        queue[0] = Integer.parseInt(data[1]);
                        top++;
                        break;
                    case "push_back":
                        top++;
                        queue[top]=Integer.parseInt(data[1]);
                        break;
                    case "pop_front":
                        if(top<0) bw.write("-1\n");
                        else{
                            bw.write(String.valueOf(queue[0])+"\n");
                            for(int j = 0; j<top; j++){
                                queue[j] = queue[j+1];
                            }
                            top--;
                        }
                        bw.flush();
                        break;
                    case "pop_back":
                        if(top<0) bw.write("-1\n");
                        else bw.write(String.valueOf(queue[top--])+"\n");
                        bw.flush();
                        break;
                    case "size":
                        bw.write(String.valueOf(top+1)+"\n");
                        bw.flush();
                        break;
                    case "empty":
                        if(top<0) bw.write("1\n");
                        else bw.write("0\n");
                        bw.flush();
                        break;
                    case "front":
                        if(top<0) bw.write("-1\n");
                        else bw.write(String.valueOf(queue[0])+"\n");
                        bw.flush();
                        break;
                    case "back":
                        if(top<0) bw.write("-1\n");
                        else bw.write(String.valueOf(queue[top])+"\n");
                        bw.flush();
                        break;
                }
            }
        }catch(Exception e){

        }
    }
}
