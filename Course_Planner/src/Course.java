public class Course {
    private String courseNum;
    private String courseName;
    private int credits;

    public Course (int credits) {
        this.credits = credits;
    }

    public Course (String courseNum, int credits) {
        this.courseNum = courseNum;
        this.credits = credits;
    }

    public Course (String courseNum, String courseName, int credits) {
        this.courseNum = courseNum;
        this.courseName =  courseName;
        this.credits = credits;
    }

    public String getNum () {
        return this.courseNum;
    }

    public void setNum (String courseNum) {
        this.courseNum = courseNum;
    }

    public String getName () {
        return this.courseName;
    }

    public void setName (String courseName) {
        this.courseName = courseName;
    }

    public int getCredits () {
        return this.credits;
    }

    public void setCredits (int credits) {
        this.credits = credits;
    }

    public String toString () {
        return courseNum + ": " + courseName + "(" + credits  + ")" + "\n";
    }
}
