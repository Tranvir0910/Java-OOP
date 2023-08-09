import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser){
        // Start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            // If largestSoFar is nothing
            CSVMaxRefactored ref = new CSVMaxRefactored();
            largestSoFar = ref.getLargestOfTwo(currentRow, largestSoFar);
        }
        // return largestSoFar is answered
        return largestSoFar;
    }
}
