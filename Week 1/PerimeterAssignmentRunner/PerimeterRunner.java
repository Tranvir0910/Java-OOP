import edu.duke.*;

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

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);

        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);

        int cnt = getNumPoints(s);
        System.out.println("num point = " + cnt);

        double averLength = getAverageLength(s);
        System.out.println("average point: " + averLength);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
