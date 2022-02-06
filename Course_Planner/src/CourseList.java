import java.util.ArrayList;

public class CourseList {
    protected ArrayList<Course> courseList;

    public CourseList () {
        this.courseList = new ArrayList<Course>();
    }

    public void addCourse (Course c) {
        courseList.add(c);
    }

    public void addCourse (String courseNum, String courseName, int credits) {
        Course c = new Course(courseNum, courseName, credits);
        courseList.add(c);
    }

    public ArrayList<Course> getCourses () {
        return this.courseList;
    }

    public String toString () {
        String output = "";
        for (Course course : courseList) {
            output += (course.toString());
        }
        return output;
    }
}
