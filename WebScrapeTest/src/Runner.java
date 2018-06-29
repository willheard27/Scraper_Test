import java.io.IOException;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Runner {
	
	public static void mainTest(String[] args) {
		String html = "<p>An <a href='http://wikipedia.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();

		String text = doc.body().text(); // "An example link"
		String linkHref = link.attr("href"); // "http://example.com/"
		String linkText = link.text(); // "example""
		
		System.out.println("hey");
		System.out.println(text);
		
	}
	
	public static void main(String[] args) throws IOException {
		String url = "https://www.sportsbookreview.com/betting-odds/nfl-football/";

        Document doc = Jsoup.connect(url).get();
        String title = doc.title();
        System.out.println("Title: " + title);
        List holderList = doc.getAllElements();
        System.out.println(holderList.size());
        //System.out.println("Second Size: " + doc.getAllElements().size());
        for(int i = 0; i < 2000; i++) {
        	System.out.println(i + "-->" + (((Element) holderList.get(i)).text()));
        }
        //GETTING THERE, KEEP WORKING
        //NOTE: consider looking at a oddsshark or something like that that compares all different betting sites and has additional statistics
	}
	
}
