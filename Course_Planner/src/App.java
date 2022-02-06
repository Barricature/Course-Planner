

public class App {
    public static void main(String[] args) throws Exception {
        String urlSp22 = "https://www.cics.umass.edu/content/spring-22-course-schedule";
        ScheduleProcessor sp22 = new ScheduleProcessor(urlSp22, "sp22");
        sp22.parseSchedule();

        CourseList cl = new CourseList();
        ScheduleAccessor sa = new ScheduleAccessor("sp22.txt", cl);
        //sa.parseIntoLines();

        sa.addCourse();
        System.out.println(cl.toString());
    }
}
