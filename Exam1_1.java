
class Exam1_1  {
    public String solution(String input_string) {
        //어떤 문자가 최초로 나오는 지점만 카운트. 최초지점이 2개 이상인 경우 외톨이임.
        char[] c = input_string.toCharArray();
        int[] count = new int[26];
        char before = c[0];
        count[c[0]-'a']++;
        for(int i = 1; i<c.length; i++){
            if(before != c[i]){
                count[c[i]-'a']++;
            }
            before = c[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<count.length; i++){
            if(count[i]>1)sb.append((char)('a'+i));
        }
        String answer = "N";
        if(sb.length()!=0){
            answer = sb.toString();
        }
        return answer;
    }
}