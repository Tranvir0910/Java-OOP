import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.File;

public class CSVFileColdestDay {
    public String fileWithColdestTemperature(){

        ParsingWeatherData pwd = new ParsingWeatherData();
        DirectoryResource dr = new DirectoryResource();

        CSVRecord coldestRecord = null;
        String coldestFileName = "";

        for (File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            CSVRecord currentColdest = pwd.coldestHourInFile(fr.getCSVParser());

            if (coldestRecord == null) {
                coldestRecord = currentColdest;
                coldestFileName = file.getName();
            } else {
                double currentTemp = Double.parseDouble(currentColdest.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestRecord.get("TemperatureF"));

                if (currentTemp < coldestTemp && currentTemp != -9999) {
                    coldestRecord = currentColdest;
                    coldestFileName = file.getName();
                }
            }
        }
        return coldestFileName;
    }

    public void testFileWithColdestTemperature() {
        String coldestFile = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coldestFile);

        FileResource fileResource = new FileResource();
        ParsingWeatherData pwd = new ParsingWeatherData();
        CSVParser parser = fileResource.getCSVParser();
        CSVRecord coldestRecord = pwd.coldestHourInFile(parser);

        System.out.println("Coldest temperature on that day was " + coldestRecord.get("TemperatureF") +
                " at " + coldestRecord.get("DateUTC"));
        System.out.println("All the Temperatures on the coldest day were:");

        parser = fileResource.getCSVParser();
        for(CSVRecord record : parser){
            System.out.println(record.get("DateUTC") + ": " + record.get("TemperatureF"));
        }
    }
}
