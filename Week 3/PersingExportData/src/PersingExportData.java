
import edu.duke.*;
import org.apache.commons.csv.*;

public class PersingExportData {
    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord record : parser){
            String ct = record.get("Country");
            if(ct.contains(country)){
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                return ct + ": " + exports + ": " + value;
            }
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                String country = record.get("Country");
                System.out.println(country);
            }

        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem){
        int cnt = 0;
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem)){
                ++cnt;
            }
        }
        return cnt;
    }

    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            if(value.length() > amount.length()){
                System.out.print(record.get("Country") + " ");
                System.out.println(value);
            }
        }
    }


    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();

        String result1 = countryInfo(parser, "Nauru");
        System.out.println(result1);
        // Reset the parser
        parser = fr.getCSVParser();

        listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();

        int result2 = numberOfExporters(parser, "sugar");
        System.out.println(result2);
        parser = fr.getCSVParser();

        bigExporters(parser, "$999,999,999,999");
    }
}
