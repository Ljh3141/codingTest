import java.util.*;
class HashPractice {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> ids = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();
        for(int i = 0; i<report.length; i++){
            String[] data = report[i].split(" ");
            String from = data[0];
            String to = data[1];
            if(!ids.containsKey(from)){
                ids.put(from, new HashSet<String>());
            }
            if(!reportCount.containsKey(to)){
                reportCount.put(to,0);
            }
            if(ids.get(from).contains(to)) continue;
            ids.get(from).add(to);
            int count = reportCount.get(to);
            count++;
            reportCount.replace(to, count);
        }
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            if(!ids.containsKey(id_list[i])) continue;
            Iterator<String> iter = ids.get(id_list[i]).iterator();
            while(iter.hasNext()){
                String nextI = iter.next();
                if(reportCount.get(nextI)>=k){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}