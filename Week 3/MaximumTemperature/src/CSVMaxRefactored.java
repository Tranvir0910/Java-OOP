import org.apache.commons.csv.CSVRecord;

public class CSVMaxRefactored {

    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
        if (largestSoFar == null){
            largestSoFar = currentRow;
        }
        // Otherwise
        else{
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            // Check if currentRow's temperature > largestSoFar
            if (currentTemp > largestTemp) {
                // Update largestSoFar = currentRow
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }
}
