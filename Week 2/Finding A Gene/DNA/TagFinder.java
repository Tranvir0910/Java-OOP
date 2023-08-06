/*
Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
that is a multiple of 3 letters long.
*/

import java.io.*;

public class TagFinder {
    public String findProtein(String dna) {
        
        // start gene is ATG
        int start = dna.indexOf("atg");
        if (start == -1) {
            return "Empty Gene";
        }
        
        // End gene is TAG
        int stop = dna.indexOf("tag", start+3);
        if ((stop - start) % 3 == 0) {
            // Return sub gene
            return dna.substring(start, stop + 3 );
        }
        else {
            return "Empty Gene";
        }
    }
    
    public void testing() {
        
        String a = "cccatggggtttaaataataataggagagagagagagagttt";
        String ap = "atggggtttaaataataatag";
        String result = findProtein(a);
        
        if (ap.equals(result)) {
            System.out.println("success for " + ap + " length " + ap.length());
        }
        else {
            System.out.println("mistake for input: " + a);
            System.out.println("got: " + result);
            System.out.println("not: " + ap);
        }
    }
}
