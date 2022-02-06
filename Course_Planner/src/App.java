

public class App {
    public static void main(String[] args) throws Exception {
        ScheduleProcessor sp22 = new ScheduleProcessor
        ("sp22", "https://www.cics.umass.edu/content/spring-22-course-schedule");
        sp22.parseSchedule();
    }
}
