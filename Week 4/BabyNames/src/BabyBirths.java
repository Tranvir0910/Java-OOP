import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                        " Gender " + rec.get(1) +
                        " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int numberGirls = 0;
        int numberBoys = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                ++numberBoys;
            }
            else {
                totalGirls += numBorn;
                ++numberGirls;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        System.out.println("number boys = " + numberBoys);
        System.out.println("number girl = " + numberGirls);
    }

    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public int getRank(int year, String name, String gender){
        int rank = 1;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            String currName = record.get(0);
            String currGender = record.get(1);
            if(currGender.equals(gender)){
                if(currName.equals(name)){
                    return rank;
                }
                rank++;
            }
        }
        return -1;
    }
    public void testGetRank(){
        int result = getRank(1960, "Frank", "M");
        if(result != -1){
            System.out.println(result);
        }else{
            System.out.println("NO RANK");
        }
    }

    public String getName(int year, String gender, int rank){
        String nameRank = "";
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int cntRank = 0;
        for(CSVRecord record : parser) {
            String currName = record.get(0);
            String currGender = record.get(1);
            if (currGender.equals(gender)) {
                cntRank++;
            }
            if(cntRank == rank){
                nameRank = currName;
                return nameRank;
            }
        }
        return "NO NAME";
    }
    public void testGetName(){
        String result = getName(1982, "M", 450);
        if(!result.equals("NO NAME")){
            System.out.println(result);
        }else{
            System.out.println("NO NAME");
        }
    }
    public String whatIsNameInYear(String name, int year, int newYear, String gender){
        int rankNameInYear = getRank(year, name, gender);
        return getName(newYear, gender, rankNameInYear);
    }
    public void testWhatIsNameInYear(){
        String result = whatIsNameInYear("Owen", 1974, 2014, "M");
        System.out.println(result);
    }

    public int yearOfHighestRank(String name, String gender){

        DirectoryResource dr = new DirectoryResource();
        int highestRank = Integer.MAX_VALUE;
        int highestYear = -1;

        for(File f : dr.selectedFiles()){

            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);

            int currYear = Integer.parseInt(f.getName().substring(3, 7)); // Extract year from file name
            int rank = 1;
            boolean found = false;

            for(CSVRecord record : parser){
                String currName = record.get(0);
                String currGender = record.get(1);
                if(currGender.equals(gender)){
                    if(currName.equals(name)){
                        found = true;
                        if (rank < highestRank) {
                            highestRank = rank;
                            highestYear = currYear;
                        }
                        break;
                    }
                    ++rank;
                }
            }
            if (!found) {
                rank = -1; // Reset rank if not found in current year's file
            }
        }
        return highestYear;
    }
    public void testYearOfHighestRank(){
        int result = yearOfHighestRank("Mich", "M");
        System.out.println(result);
    }

    public double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        double sum = 0;
        int cnt = 0;

        for(File f : dr.selectedFiles()){
            int rank = 1;
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            int currYear = Integer.parseInt(f.getName().substring(3, 7));
            for(CSVRecord record : parser) {
                String currName = record.get(0);
                String currGender = record.get(1);
                if (currGender.equals(gender)) {
                    if (currName.equals(name)) {
                        sum += rank;
                        ++cnt;
                        break;
                    }
                    ++rank;
                }
            }
        }
        return sum/cnt;
    }
    public void testAverageRank(){
        double result = getAverageRank("Robert","M");
        System.out.println(result);
    }
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int sum = 0;
        for(CSVRecord record : parser){
            String currName = record.get(0);
            String currGender = record.get(1);
            int currBirth = Integer.parseInt(record.get(2));
            if(currGender.equals(gender)){
                if(currName.equals(name)){
                    break;
                }
                sum += currBirth;
            }
        }
        return sum;
    }
    public void testGetTotalBirthsRankedHigher(){
        int result = getTotalBirthsRankedHigher(1990, "Emily", "F");
        System.out.println(result);
    }
}
