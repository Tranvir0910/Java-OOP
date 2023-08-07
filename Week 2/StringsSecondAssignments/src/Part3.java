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
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if (minIndex == dna.length()) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }
    
    // Phương thức đếm số lượng gene trong DNA
    public int countGenes(String dna) {
        int count = 0;
        while (true) {
            String gene = findGene(dna);
            if (gene.isEmpty()) {
                break;
            }
            count++;
            dna = dna.substring(dna.indexOf(gene) + gene.length());
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
