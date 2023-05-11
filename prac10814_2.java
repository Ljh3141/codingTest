import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class prac10814_2 {
    public static void main(String[] args){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int k = Integer.parseInt(br.readLine());
            Person[] p = new Person[k];
            for(int i = 0; i<k; i++){
                String[] data = br.readLine().split(" ");
                p[i]= new Person(Integer.parseInt(data[0]),data[1], i);
            }
            Arrays.sort(p);
            for(int i = 0; i<k; i++){
                bw.write(p[i].age+" "+p[i].name+"\n");
            }
            bw.flush();
            bw.close();
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Person implements Comparable<Person>{
    public int age;
    public int id;
    public String name;

    public Person(int age, String name, int id){
        this.age = age;
        this.name = name;
        this.id = id;
    }

    @Override
    public int compareTo(Person o) {
        // TODO Auto-generated method stub
        if(this.age == o.age){
            return this.id>o.id?1:-1;
        }else{
            return this.age-o.age;
        }
    }
}
