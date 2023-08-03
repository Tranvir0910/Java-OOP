
/**
 * Write a description of Part1 here.
 * 
 * @author (ViTran) 
 * @version (03/08/2023)
 */

public class Part2 {
    public String findSimpleGene(String dna){
        // Tìm vị trí chỉ số của codon bắt đầu "ATG". 
        // Nếu không có "ATG", trả về chuỗi rỗng.
        int startCodon = dna.indexOf("ATG");
        if ( startCodon == -1 ){
            return "Empty String";
        }
        
        // Tìm vị trí chỉ số của codon dừng đầu tiên "TAA" xuất hiện sau "ATG" đã tìm thấy.
        // Nếu không có "TAA" như vậy, trả về chuỗi rỗng.
        int stopCodon = dna.indexOf("TAA", startCodon + 3);
        if ( stopCodon == -1 ){
            return "Empty String";
        }
        
        // Nếu độ dài của chuỗi con giữa "ATG" và "TAA" là bội số của 3, 
        // thì trả về chuỗi con bắt đầu bằng "ATG" và kết thúc bằng "TAA".
        if ((stopCodon - startCodon) % 3 == 0 ){
            return dna.substring(startCodon, stopCodon + 3);
        }else{
            return "Empty String";
        }
    }
    public void testSimpleGene(){
        String a = "ATGGGTTAAGTC";
        String b = "gatgctataat";
        
        String result1 = findSimpleGene(a);
        System.out.println("Gene is " + result1);
        
        String result2 = findSimpleGene(b.toUpperCase());
        System.out.println("Gene is " + result2.toLowerCase());
    }
}
