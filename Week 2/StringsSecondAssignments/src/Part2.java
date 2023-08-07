public class Part2 {
    public int howMany(String a, String b){
        int startIdx = 0;
        int cnt = 0;
        while(true){
            int currIdx = b.indexOf(a, startIdx);
            if(currIdx == -1){
                break;
            }else{
                cnt++;
                startIdx = currIdx + a.length();
            }
        }
        return cnt;
    }  
}
