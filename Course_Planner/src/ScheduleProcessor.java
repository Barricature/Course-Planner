import java.io.IOException;

import java.util.Scanner;
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
            File path = new File("sp22.txt");
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);

            Document doc = Jsoup.connect(this.url).timeout(6000).get();
            Element tbody = doc.select("tbody").first();
            Elements trs = tbody.select("tr");
     
            for (Element tr : trs){
                if (tr.select("th").size() > 0) {
                    pw.println(tr.select("th").first().text());
                }
                else if (Character.isDigit(tr.text().charAt(0))){
                    pw.println(tr.text());
                }
            }
            pw.close();
         }
         catch (IOException e) {
             e.printStackTrace();
         }
    }

}