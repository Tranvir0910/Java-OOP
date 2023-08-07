
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public double cgRatio(String dna) {
        int countC = 0;
        int countG = 0;
        
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C') {
                countC++;
            } else if (dna.charAt(i) == 'G') {
                countG++;
            }
        }
        return (double) (countC + countG) / dna.length();
    }
    
    public int countCTG(String dna) {
        int count = 0;
        int startIndex = dna.indexOf("CTG");
        while (startIndex != -1) {
            count++;
            startIndex = dna.indexOf("CTG", startIndex + 3);
        }
        return count;
    }
    
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        
        String dna = "ATGCTGAGCTGCCCTAGTACGTG";
        System.out.println("C-G Ratio: " + part2.cgRatio(dna));
        System.out.println("CTG Count: " + part2.countCTG(dna));
    }
}
