//Collections.sort()를 활용하자..

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class prac2751 {
    public static void main(String[]args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] data = new int[k];
        for(int i = 0; i<k;i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        //정렬
        Mergesort mergesort =new Mergesort();
        mergesort.mergeSort(data,0,data.length-1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<k;i++){
            sb.append(data[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Mergesort{
    public void mergeSort(int[] arr, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i = left, k = 0;
        int j = mid+1;
        while(i<=mid && j<=right) {
            if(arr[i]<=arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid) {
            temp[k++] = arr[i++];
        }
        while(j<=right) {
            temp[k++] = arr[j++];
        }
        i = left;
        k = 0;
        while(i<=right) {
            arr[i++] = temp[k++];
        }
    }
}

/* 
public class prac2751 {
    public static void main(String[]args){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int k = Integer.parseInt(br.readLine());
            int[] data = new int[k];
            for(int i = 0; i<k;i++){
                data[i] = Integer.parseInt(br.readLine());
            }
            Quicksort qs =new Quicksort();
            qs.quickSort(data);
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<k;i++){
                sb.append(data[i]+"\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Quicksort{
    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr, start, end);

        if(start < part2 - 1){
            quickSort(arr, start, part2 - 1);
        }

        if(part2 < end){
            quickSort(arr, part2, end);
        }
    }

    public int partition(int[] arr, int start, int end){
        int pivot = arr[(start + end) / 2];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
*/