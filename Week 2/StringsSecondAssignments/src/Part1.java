public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        
        int currIdx = dna.indexOf(stopCodon, startIndex + 3);

        while( currIdx != -1 ){
            if((currIdx - startIndex) % 3 == 0){
                return currIdx;
            }else{
                currIdx = dna.indexOf(stopCodon, currIdx + 1);
            }
        }
        return dna.length();
    }

    public String findGene(String dna){
        int startIdx = dna.indexOf("ATG");
        if (startIdx == -1) {
            return "";
        }

        int TAAindex = findStopCodon(dna, startIdx + 3, "TAA");
        
        int TAGindex = findStopCodon(dna, startIdx + 3, "TAG");
        
        int TGAindex = findStopCodon(dna, startIdx + 3, "TGA");
       

        int minIndex = Math.min(TAAindex, Math.min(TGAindex, TAGindex));

        if(minIndex == dna.length()){
            return "";
        }else{
            return dna.substring(startIdx, minIndex + 3);
        }
    }

    public void printAllGene(String dna){
        // int startIdx = 0;
        while (true) {
            String currentGene = findGene(dna);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println("Gene found: " + currentGene);
            // startIdx = dna.indexOf(currentGene, startIdx) + currentGene.length();
            dna = dna.substring(dna.indexOf(currentGene) + currentGene.length());
        }
    }
}
