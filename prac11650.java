import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class prac11650 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            int k = Integer.parseInt(br.readLine());
            Point[] arr = new Point[k];

            for(int i = 0; i<k ; i++){
                String[] data = br.readLine().split(" ");
                int x=Integer.parseInt(data[0]);
                int y =Integer.parseInt(data[1]);
                arr[i]=new Point(x,y);
            }
            Arrays.sort(arr);
            for(Point p : arr){
                bw.write(p.x+" "+p.y+"\n");
            }
            bw.flush();
            br.close();
            bw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Point implements Comparable<Point>{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Point p) {
        // TODO Auto-generated method stub
        if(this.x==p.x){
            return this.y-p.y;
        }
        else return this.x-p.x;
    }
}
