import java.io.IOException;

import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScheduleProcessor{

    private String url;
    private String name;


    public ScheduleProcessor (String url, String name) {
        this.url = url;
        this.name = name;
    }
    
    public void parseSchedule () throws IOException{
        try {
            String path = this.name + ".txt";
            File f = new File(path);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            Document doc = Jsoup.connect(this.url).timeout(6000).get();
            Element tbody = doc.select("tbody").first();
            Elements trs = tbody.select("tr");
     
            for (Element tr : trs){
                if (tr.select("th").size() > 0) {
                    pw.println(tr.select("th").first().text());
                }
                else if (Character.isDigit(tr.text().charAt(0))){
                    Elements tds = tr.select("td");
                    
                    String courseNum = tds.get(0).text();
                    String[] nameAndCredit = tds.get(1).text().split(" \\(");
                    String courseName = nameAndCredit[0];
                    String intValue = nameAndCredit[1].replaceAll("[^0-9]", "");
                    int credits = Integer.valueOf(intValue);

                    pw.print(courseNum + ",, " + courseName + ",, " + credits);
                    pw.println("");
                }
            }
            pw.close();
         }
         catch (IOException e) {
             e.printStackTrace();
         }
    }

}