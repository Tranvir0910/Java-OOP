import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class AverageHumidity {
    public double averageTemperatureInFile(CSVParser parser){
        double sum = 0;
        int rowCount = 0;
        for(CSVRecord record : parser){
            String tempStr = record.get("TemperatureF");
            if(!tempStr.equals("N/A")){
                double temp = Double.parseDouble(tempStr);
                sum += temp;
                ++rowCount;
            }
        }
        return sum/rowCount;
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double result = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + result);
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double sum = 0;
        int rowCount = 0;
        for(CSVRecord record : parser){
            String tempStr = record.get("TemperatureF");
            if(!tempStr.equals("N/A")){
                double temp = Double.parseDouble(tempStr);
                double humidity = Double.parseDouble(record.get("Humidity"));
                if(humidity >= value) {
                    sum += temp;
                    ++rowCount;
                }
            }
        }
        return sum/rowCount;
    }
    public void testAverageTemperatureWithHighHumidityInFile(){

        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double result = averageTemperatureWithHighHumidityInFile(parser, 80);

        if(result == 0){
            System.out.println("No temperatures with that humidity");
        }else{
            System.out.println("Average Temp when high Humidity is " + result);
        }
    }
}
