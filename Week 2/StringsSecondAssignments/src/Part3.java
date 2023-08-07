public class Part3 {
    
    // Phương thức tìm chỉ số của stopCodon sau startIndex và cách startIndex một bội số của 3
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }
    
    // Phương thức tìm gene trong DNA
    public String findGene(String dna) {
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
    
    // Phương thức đếm số lượng gene trong DNA
    public int countGenes(String dna) {
        int count = 0;
        while (true) {
            String currentGene = findGene(dna);
            if (currentGene.isEmpty()) {
                break;
            }
            count++;
            dna = dna.substring(dna.indexOf(currentGene) + currentGene.length());
        }
        return count;
    }
    
    // Phương thức kiểm tra và in kết quả đếm số lượng gene
    public void testCountGenes() {
        String[] testDNA = {
            "ATGTAAGATGCCCTAGT",  // 2 genes
            "ATGAGTAA",           // 1 gene
            "ATGTAG",             // 0 gene
            "AGTAGTAGTAGTA"       // 0 gene
        };
        
        for (String dna : testDNA) {
            int geneCount = countGenes(dna);
            System.out.println("DNA: " + dna);
            System.out.println("Gene count: " + geneCount);
        }
    }
}
