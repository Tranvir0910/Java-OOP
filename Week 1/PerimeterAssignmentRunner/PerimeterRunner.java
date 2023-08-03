import edu.duke.*;
import java.io.File;

public class PerimeterRunner {

    
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints(Shape s){
        // Count Point in shape
        int cntPoint = 0;
        for ( Point currPt : s.getPoints()){
            cntPoint += 1;
        }
        return cntPoint;
    }

    public double getAverageLength(Shape s){
        Point prevPt = s.getLastPoint();
        double sumAverLength = 0;
        int cnt = getNumPoints(s);
        for( Point currPt : s.getPoints() ){
            double currDist = prevPt.distance(currPt);
            sumAverLength += currDist;
            prevPt = currPt;
        }
        return sumAverLength / cnt;
    }

    public double getLargestSide(Shape s){
        double rec = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if (currDist > rec) rec = currDist;
            prevPt = currPt;
        }
        return rec;
    }
    
    public double getLargestX(Shape s){
        double rec = 0;
        for(Point currPt : s.getPoints()){
            if (currPt.getX() > rec){
                rec = currPt.getX();
            }
        }
        return rec; 
    }
    
    
    
    public double getLargestPerimeterMultipleFiles(){
        DirectoryResource dr = new DirectoryResource();
        double rec = 0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(perimeter > rec){
                rec = perimeter;
            }
        }
        return rec;
    }
    
    public String getFileWithLargestPerimeter() {
        File temp = null;  
        DirectoryResource dr = new DirectoryResource();
        double rec = 0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(perimeter > rec){
                rec = perimeter;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);

        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);

        int cnt = getNumPoints(s);
        System.out.println("num point = " + cnt);

        double averLength = getAverageLength(s);
        System.out.println("average point: " + averLength);

        double largeSide = getLargestSide(s);
        System.out.println("large side = " + largeSide);
        
        double largeX = getLargestX(s);
        System.out.println("large X = " + largeX);
        
        double largestPerimeterMultiFiles = getLargestPerimeterMultipleFiles();
        System.out.println("large perimeter = " + largestPerimeterMultiFiles);
        
        String getFileWithLargestPerimeter = getFileWithLargestPerimeter();
        System.out.println("file name = " + getFileWithLargestPerimeter);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
