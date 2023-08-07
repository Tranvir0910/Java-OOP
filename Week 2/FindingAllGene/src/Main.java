public class Main {

    public static void testSimpleGene(){

        String dna = "AATGCGTAATTAATCG";
        System.out.println(dna);

        FindGenWhile obj = new FindGenWhile();
        String gene = obj.findGene(dna);
        System.out.println("Gene is: " + gene);


    }

    public static void testFindStop(){

        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        
        AllCodons obj = new AllCodons();

        int dex = obj.findStopCodon(dna, 0, "TAA");
        if(dex != 9) System.out.println("error on 9");

        dex = obj.findStopCodon(dna, 9, "TAA");
        if(dex != 21) System.out.println("error on 21");

        dex = obj.findStopCodon(dna, 1, "TAA");
        if(dex != -1) System.out.println("error on 26");

        dex = obj.findStopCodon(dna, 0, "TAG");
        if(dex != -1) System.out.println("error on 26 TAG");

        System.out.println("Test Finished!!");

        System.out.println("Gene is : " + obj.findGene(dna, 0));


    }

    public static void testFindGene(){
        AllCodons obj = new AllCodons();
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = obj.findGene(dna, 0);

        if (!gene.equals("ATGCCCGGGAAATAA"))
            System.out.println("erorr!!");
        System.out.println("Test Finished!!!");

        String dna1 = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        String dna2 = "";
        String dna3 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";

        System.out.println("Testing printAllGenes on " + dna1);
        obj.printAllGene(dna1);
        System.out.println("Testing printAllGenes on " + dna2);
        obj.printAllGene(dna2);
        System.out.println("Testing printAllGenes on " + dna3);
        obj.printAllGene(dna3);
    }
    public static void main(String[] args) throws Exception {
        testSimpleGene();
        testFindStop();
        testFindGene();
    }
}


