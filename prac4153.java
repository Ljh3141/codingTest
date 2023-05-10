import java.util.Scanner;

public class prac4153 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] datas = new int[3];
        while(true){
            for(int i = 0; i<3;i++){
                datas[i] = scanner.nextInt();
            }
            if(datas[0]==0)break;
            boolean tri = false;
            if(datas[0]>datas[1]){
                if(datas[0]>datas[2]){
                    if(Math.pow(datas[0],2)==Math.pow(datas[1],2)+Math.pow(datas[2],2)) tri = true;
                }else{
                    if(Math.pow(datas[2],2)==Math.pow(datas[1],2)+Math.pow(datas[0],2)) tri = true;
                }
            }else{
                if(datas[1]>datas[2]){
                    if(Math.pow(datas[1],2)==Math.pow(datas[0],2)+Math.pow(datas[2],2)) tri = true;
                }else{
                    if(Math.pow(datas[2],2)==Math.pow(datas[1],2)+Math.pow(datas[0],2)) tri = true;
                }
            }
            if(tri){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }        
}
