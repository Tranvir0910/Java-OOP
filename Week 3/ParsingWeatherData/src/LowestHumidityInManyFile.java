import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class LowestHumidityInManyFile {
    public CSVRecord LowestHumidityInManyFiles() {

        LowestHumidity lw = new LowestHumidity();
        DirectoryResource dr = new DirectoryResource();
        CSVRecord humidityRecord = null;

        for (File file : dr.selectedFiles()) {

            FileResource fr = new FileResource(file);
            CSVRecord currentLowestHumidity = lw.lowestHumidityInFile(fr.getCSVParser());

            if (humidityRecord == null){
                humidityRecord = currentLowestHumidity;
            }else{
                double currentHumidity = Double.parseDouble(currentLowestHumidity.get("Humidity"));
                double lowestHumidity = Double.parseDouble(humidityRecord.get("Humidity"));
                if(currentHumidity < lowestHumidity){
                    humidityRecord = currentLowestHumidity;
                }
            }
        }
        return humidityRecord;
    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = LowestHumidityInManyFiles();
        if( csv != null ){
            System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
        }
    }
}
