/*
A Course Planner using Terminal
@authur Iris Xia
@version 0.8
**/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String path = "sp22.txt";
        String urlSp22 = "https://www.cics.umass.edu/content/spring-22-course-schedule";
        ScheduleProcessor sp22 = new ScheduleProcessor(urlSp22, path);
        sp22.parseSchedule();

        CourseList cl = new CourseList();
        ScheduleAccessor sa = new ScheduleAccessor(path, cl);
        sa.parseIntoLines();

        sa.addCourse();
        System.out.println(cl.toString());

        System.out.println("Your Course Planner");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your entry year:");
        FourYears fy = new FourYears (scan.nextInt());
        scan.close();

        Scanner scn = new Scanner(System.in);
        boolean keepGoing = true;
        String userStr;
         
        while(keepGoing) {
            System.out.println("Main Menu:");
            System.out.println("Enter O to view courses currently offered."); 
            System.out.println("Enter F to view your future four years."); 
            System.out.println("Enter A to add a course.");
            System.out.println("Enter X to quit.");
            System.out.println("");
            userStr = scn.nextLine();
              
            if (userStr.equalsIgnoreCase("O")){
                System.out.println(cl.toString());
            }
            else if (userStr.equalsIgnoreCase("F")){
                System.out.println(cl.toString());
            }
            else if (userStr.equalsIgnoreCase("A")){
                System.out.println("Select the Term:");
                System.out.println("1. " + fy.getFourYears()[0].toString());
                System.out.println("2. " + fy.getFourYears()[1].toString());
                System.out.println("3. " + fy.getFourYears()[2].toString());
                System.out.println("4. " + fy.getFourYears()[3].toString());
                System.out.println("5. " + fy.getFourYears()[4].toString());
                System.out.println("6. " + fy.getFourYears()[5].toString());
                System.out.println("7. " + fy.getFourYears()[6].toString());
                System.out.println("8. " + fy.getFourYears()[7].toString());
                int option = scn.nextInt();
                System.out.println("Enter the course number:");
                String courseNum = scn.nextLine();
                System.out.println("Enter the course name:");
                String courseName = scn.nextLine();
                System.out.println("Enter the course credit:");
                int credits = scn.nextInt();
                fy.fourYears[option - 1].addCourse(courseNum, courseName, credits);
                System.out.println("added");
            }
            else if(userStr.equalsIgnoreCase("X")){
                keepGoing = false;
            }   
            else{
                System.out.println("Unrecognized input.");
            }               
         }
         System.out.println("Bye for now.");
         scn.close();
    }

}
