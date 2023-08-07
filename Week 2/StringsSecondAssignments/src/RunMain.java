public class RunMain {

    // Test Part1
    public static void testFindStopCodon(){

        Part1 part1 = new Part1();

        String dna1 = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        String dna2 = "";
        String dna3 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        String dna4 = "ATGxxxyyyzzzTAATAGTGA";

        int result1 = part1.findStopCodon(dna1, 0, "TAA");
        int result2 = part1.findStopCodon(dna2, 0, "TAA");
        int result3 = part1.findStopCodon(dna3, 0, "TAA");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        System.out.println("Gene is : " + part1.findGene(dna1));
        System.out.println("Gene is : " + part1.findGene(dna2));
        System.out.println("Gene is : " + part1.findGene(dna3));
        System.out.println("Gene is : " + part1.findGene(dna4));

        part1.printAllGene(dna1);
        part1.printAllGene(dna2);
        part1.printAllGene(dna3);
        part1.printAllGene(dna4);

    }

    // Test Part2
    public static void testHowMany(){
        String a1 = "GAA";
        String b1 = "ATGAACGAATTGAATC";

        String a2 = "AA";
        String b2 = "ATAAAA";

        Part2 part2 = new Part2();
        System.out.println("Number of occurrences: " + part2.howMany(a1, b1));
        System.out.println("Number of occurrences: " + part2.howMany(a2, b2));
    }

    public static void main(String[] args) throws Exception {
        testFindStopCodon();
        testHowMany();
        Part3 part3 = new Part3();
        part3.testCountGenes();
    }
}
