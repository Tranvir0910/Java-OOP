public class FindGenWhile{
    public String findGene(String dna){
        int startIdx = dna.indexOf("ATG");
        if (startIdx == -1)
            return "";
        int currIdx = dna.indexOf("TAA", startIdx + 3);
        while (currIdx != 1){
            if( (currIdx - startIdx) % 3 == 0 ){
                return dna.substring(startIdx, currIdx + 3);
            }else{
                currIdx = dna.indexOf("TAA", currIdx + 1);
            }
        }
        return "";
    }
}