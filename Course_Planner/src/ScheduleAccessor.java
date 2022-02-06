import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;
import java.io.*;

public class ScheduleAccessor {
    private String fileName;
    private Scanner scan;
    private ArrayList<String>  lineList;
    private CourseList cList;

    public ScheduleAccessor(String fName, CourseList cl) throws IOException{
        this.fileName = fName;
        this.scan = new Scanner(new FileReader(fileName));
        cList = cl;
    }

    public void parseIntoLines () {
        lineList = new ArrayList<String>();

        while(scan.hasNext()) {
            lineList.add(scan.nextLine());
        }
        
        scan.close();
    }

    public void addCourse () {
        String department = "";

        this.parseIntoLines();
        
        for (String line : lineList) {
            if (line.split(", ").length == 1) {
                department = line;
            }
            else {
                String[] fields = line.split(",, ");
                String courseNum = department + fields[0];
                String courseName = fields[1];
                int credits = Integer.parseInt(fields[2]);
                cList.addCourse(courseNum, courseName, credits);
            }
        }
    }


}
