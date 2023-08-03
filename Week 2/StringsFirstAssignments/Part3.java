
/**
 * Write a description of Part3 here.
 * 
 * @author (ViTran) 
 * @version (03/08/2023)
 */

public class Part3 {
    public String twoOccurrences( String stringa, String stringb ){
        int startIdx = stringb.indexOf( stringa );
        int stopIdx = stringb.indexOf( stringa, startIdx + stringa.length());

        if ( stopIdx == -1 ) {
            return "false";
        }else{
            return "true";
        }
    }
    
    public String lastPart( String stringa, String stringb ){
        int startIdx = stringb.indexOf( stringa );
        int stopIdx = stringb.indexOf( stringa, startIdx + stringa.length());
        if ( stopIdx == -1 ){
            return stringb;
        }else{
            return stringb.substring(stopIdx);
        }
    }
    
    public void testing(){
        String a1 = "by";
        String b1 = "A story by Abby Long";
        
        String a2 = "a";
        String b2 = "banana";
        
        String a3 = "atg";
        String b3 = "ctgtatgta";
        
        String a4 = "an";
        String b4 = "banana";
        
        String a5 = "zoo";
        String b5 = "forest";
        
        String result1 = twoOccurrences(a1, b1);
        String result2 = twoOccurrences(a2, b2);
        String result3 = twoOccurrences(a3, b3);
        
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        
        String result4 = lastPart(a4, b4);
        String result5 = lastPart(a5, b5);
        
        System.out.println(result4);
        System.out.println(result5);
        
        
    }
}
