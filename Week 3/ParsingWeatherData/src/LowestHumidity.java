import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class LowestHumidity {
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidityRecord = null;

        for (CSVRecord record : parser) {
            String humidityStr = record.get("Humidity");
            if (!humidityStr.equals("N/A")) {
                double humidity = Double.parseDouble(humidityStr);

                if (lowestHumidityRecord == null || humidity < Double.parseDouble(lowestHumidityRecord.get("Humidity"))) {
                    lowestHumidityRecord = record;
                }
            }
        }

        return lowestHumidityRecord;
    }

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);

        if( csv != null ){
            System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
        }
    }
}
