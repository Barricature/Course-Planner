import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.*;

public class CourseList {
    private ArrayList<Course> courseList;

    public CourseList () {
        this.courseList = new ArrayList<Course>();
    }

    public void addCourse (String courseNum, String courseName, int credits) {
        Course c = new Course(courseNum, courseName, credits);
        courseList.add(c);
    }

    public String toString () {
        String output = "";
        for (Course course : courseList) {
            output += (course.toString());
        }
        return output;
    }
}
