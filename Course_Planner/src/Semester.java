public class Semester extends CourseList{
    private int year;
    private String season;

    public Semester (int year, String season) {
        super();
        this.year = year;
        this.season = season;
    }

    public boolean creditOverload () {
        int totalCredits = 0;
        for (Course course : super.courseList) {
            totalCredits += course.getCredits();
        }
        return totalCredits >= 19;
    }

    public int getYear () {
        return this.year;
    }

    public String getSeason () {
        return this.season;
    }

    public String toString () {
        return  this.season + " " + String.valueOf(this.year);
    }
}
