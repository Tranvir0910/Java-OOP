
/**
 * Write a description of Part1 here.
 * 
 * @author (ViTran) 
 * @version (03/08/2023)
 */

public class Part1 {
    public String findSimpleGene(String dna){
        // Tìm vị trí chỉ số của codon bắt đầu "ATG". 
        // Nếu không có "ATG", trả về chuỗi rỗng.
        int startIdx = dna.indexOf("ATG");
        if ( startIdx == -1 ){
            return "Empty String";
        }
        
        // Tìm vị trí chỉ số của codon dừng đầu tiên "TAA" xuất hiện sau "ATG" đã tìm thấy.
        // Nếu không có "TAA" như vậy, trả về chuỗi rỗng.
        int stopIdx = dna.indexOf("TAA", startIdx + 3);
        if ( stopIdx == -1 ){
            return "Empty String";
        }
        
        // Nếu độ dài của chuỗi con giữa "ATG" và "TAA" là bội số của 3, 
        // thì trả về chuỗi con bắt đầu bằng "ATG" và kết thúc bằng "TAA".
        if ((stopIdx - startIdx) % 3 == 0 ){
            return dna.substring(startIdx, stopIdx + 3);
        }else{
            return "Empty String";
        }
    }
    public void testSimpleGene(){
        String a = "atgatggtacccagtttttaa";

        String result = findSimpleGene(a);
        
        System.out.println("Gene is " + result);
        
    }
}
