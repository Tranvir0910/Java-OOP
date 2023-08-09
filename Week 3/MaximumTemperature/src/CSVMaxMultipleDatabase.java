import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVMaxMultipleDatabase {
    CSVRecord largestSoFar = null;
    public CSVRecord hottestInManyDay(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVMax weatherTest = new CSVMax();
            CSVRecord currentRow = weatherTest.hottestHourInFile(fr.getCSVParser());
            CSVMaxRefactored ref = new CSVMaxRefactored();
            largestSoFar = ref.getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }
}
