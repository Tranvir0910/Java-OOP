
import edu.duke.*;

public class Part3 {
    
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
    
    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        while (true) {
            String gene = findGene(dna);
            if (gene.isEmpty()) {
                break;
            }
            geneList.add(gene);
            dna = dna.substring(dna.indexOf(gene) + gene.length());
        }
        return geneList;
    }
    
    /*
    public void test(){
        Part1 part1 = new Part1();
        String dna = "ATGTAAGATGCCCTAGTATGTAAGATGCCCTAGT";
        StorageResource genes = part1.getAllGenes(dna);
        
        for (String gene : genes.data()) {
            System.out.println("Gene: " + gene);
        }
    }
    */
    
    public void processGenes(){
        FileResource fr = new FileResource();
        StorageResource genes = getAllGenes(fr.asString());
        int cnt1 = 0;
        for (String gene : genes.data()) {
            if(gene.length() > 9){
                System.out.println("Gene length > 9 : " + gene);
                cnt1++;
            }
        }
        System.out.println(cnt1);
        
        int cnt2 = 0;
        Part2 part2 = new Part2();
        for (String gene : genes.data()) {
            if(part2.cgRatio(gene) > 0.35){
                System.out.println("C-G Ratio > 0.35 : " + gene);
                cnt2++;
            }
        }
        System.out.println(cnt2);
    }
}
