import edu.duke.*;
import java.io.*;

/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public void findYoutubeLinks() {
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String word : ur.words()) {
            String lowerWord = word.toLowerCase();
            int youtubeIndex = lowerWord.indexOf("youtube.com");
            if (youtubeIndex != -1) {
                int startIndex = word.lastIndexOf("\"", youtubeIndex);
                int endIndex = word.indexOf("\"", youtubeIndex + 11); // 11 is the length of "youtube.com"
                if (startIndex != -1 && endIndex != -1) {
                    String youtubeLink = word.substring(startIndex + 1, endIndex);
                    System.out.println(youtubeLink);
                }
            }
        }
    }
}
