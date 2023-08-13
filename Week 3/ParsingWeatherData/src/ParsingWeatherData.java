import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParsingWeatherData {

//    Part 1:
    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
        if (largestSoFar == null){
            largestSoFar = currentRow;
        }
        // Otherwise
        else{
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            // Check if currentRow's temperature > largestSoFar
            if (currentTemp < largestTemp && currentTemp != -9999) {
                // Update largestSoFar = currentRow
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : parser) {
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }

    public void testColdestHourInFile() {
        FileResource fileResource = new FileResource();
        CSVParser parser = fileResource.getCSVParser();
        CSVRecord coldestRecord = coldestHourInFile(parser);

        if (coldestRecord != null) {
            System.out.println("Coldest temperature was " + coldestRecord.get("TemperatureF") +
                    " at " + coldestRecord.get("DateUTC"));
        }
    }
}
