import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class DiningHall { 
    private static String getUrlSource(String url) throws IOException {
	URL menupage = new URL(url);
	URLConnection menupageconnection = menupage.openConnection();
	BufferedReader in = new BufferedReader(new InputStreamReader(
	    menupageconnection.getInputStream(), "UTF-8"));
	String inputLine;
	StringBuilder a = new StringBuilder();
	while ((inputLine = in.readLine()) != null)
	a.append(inputLine);
	in.close();

	return a.toString();
    }
    public static void main(String[] args) { 
	String url;
	url = "http://menu.ha.ucla.edu/foodpro/default.asp";
	try {
        	System.out.println(getUrlSource(url));
	}
	catch(IOException e) {
		System.err.println("Caught IOException: "+e.getMessage());
	}
    }
}
