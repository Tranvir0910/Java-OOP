

public class AllCodons {

    public int findStopCodon(String dnaStr, int startIdx, String stopCodon){
        int currIdx = dnaStr.indexOf(stopCodon, startIdx + 3);
        while(currIdx != -1){
            if((currIdx - startIdx) % 3 == 0){
                return currIdx;
            }else{
                currIdx = dnaStr.indexOf(stopCodon, currIdx + 1);
            }
        }
        return -1;
    }

    public String findGene(String dna, int where){
        int startIdx = dna.indexOf("ATG", where);
        if (startIdx == -1) {
            return "";
        }
        
        int TAAindex = findStopCodon(dna, startIdx, "TAA");
        int TAGindex = findStopCodon(dna, startIdx, "TAG");
        int TGAindex = findStopCodon(dna, startIdx, "TGA");

        int minIndex = 0;

        if (TAAindex == -1 || (TGAindex != -1 && TGAindex < TAAindex))
            minIndex = TGAindex;
        else
            minIndex = TAAindex;
        
        
        if (minIndex == -1 || (TAGindex != -1 && TAGindex < minIndex))
            minIndex = TAGindex;

        if ( minIndex == -1 ) return "";

        return dna.substring(startIdx, minIndex + 3);
    }

    public void printAllGene(String dna){
        int startIdx = 0;
        while ( true ){
            // Find the next gene after Start Idx
            String currentGene = findGene(dna, startIdx);
            // If no gene -> break
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);

            startIdx = dna.indexOf(currentGene, startIdx) + currentGene.length();
        }
    }
}
