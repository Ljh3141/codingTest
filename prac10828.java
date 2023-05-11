import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class prac10828 {
    
    public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            int k = Integer.parseInt(br.readLine());
            int top = -1;
            int[] stack = new int[10000];
            for(int i = 0; i<k ; i++){
                String data = br.readLine();
                String[] order = data.split(" ");
                switch(order[0]){
                    case "push":
                        top++;
                        stack[top] = Integer.parseInt(order[1]);
                        break;
                    case "pop":
                        if(top<0) bw.write("-1\n");
                        else bw.write(String.valueOf(stack[top--])+"\n");
                        bw.flush();
                        break;
                    case "size":
                        bw.write(String.valueOf(top+1)+"\n");
                        bw.flush();
                        break;
                    case "top":
                        if(top<0) bw.write("-1\n");
                        else bw.write(String.valueOf(stack[top])+"\n");
                        bw.flush();
                        break;
                    case "empty":
                        if(top<0) bw.write("1\n");
                        else bw.write("0\n");
                        bw.flush();
                        break;
                }
                /*
                if(order[0].equals("push")){
                    //삽입
                    top++;
                    stack[top]=Integer.parseInt(order[1]);
                }else if(order[0].equals("pop")){
                    //출력+제거
                    if(top<0) bw.write(-1);

                    else System.out.println(stack[top--]);
                }else if(order[0].equals("size")){
                    //크기
                    System.out.println(top+1);
                }else if(order[0].equals("top")){
                    //출력
                    if(top<0) System.out.println(-1);
                    else System.out.println(stack[top]);
                }else if(order[0].equals("empty")){
                    if(top<0)System.out.println(1);
                    else System.out.println(0);
                } */
            }

        }catch(Exception e){

        }

    }
}
