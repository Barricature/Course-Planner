public class FourYears {
    public Semester[] fourYears = new Semester[8];

    public FourYears (int entryYear) {
        for (int i = 0; i < 8; i++){
            String season;
            if (i % 2 == 0){
                season = "Fall";
            }
            else{
                season = "Spring";
            }
            fourYears[i] = new Semester(entryYear + i / 2, season);
        } 
    }

    public Semester[] getFourYears () {
        return this.fourYears;
    }

    public String toString() {
        String output = "";
        for (Semester s : this.fourYears) {
            output += s.toString() + ":" + "\n";
            for (Course c : s.getCourses()) {
                output += c.toString() + "\n";
            }
        }
        return output;
    }
    
}
