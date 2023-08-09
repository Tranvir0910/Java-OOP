import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Main {
    public static void testHottestInManyDay(){
        CSVMaxMultipleDatabase manyDay = new CSVMaxMultipleDatabase();
        CSVRecord largest = manyDay.hottestInManyDay();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("DateUTC"));

    }
    public static void main(String[] args){
        CSVMax weatherTest = new CSVMax();
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord largest = weatherTest.hottestHourInFile(parser);

        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
        parser = fr.getCSVParser();

        testHottestInManyDay();

    }
}
