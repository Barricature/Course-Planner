import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
    public static void main(String[] args) throws IOException {
        String url = "https://www.cics.umass.edu/content/spring-22-course-schedule";
        try {
           Document sp22Schedule = Jsoup.connect(url).timeout(6000).get();
           Element tbody = sp22Schedule.select("tbody").first();
           Elements trs = tbody.select("tr");

           for (Element tr : trs){
               if (Character.isDigit(tr.text().charAt(0))){
                System.out.println(tr.text());
               }
           }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
