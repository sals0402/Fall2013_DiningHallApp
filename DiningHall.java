import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import org.w3c.tidy.Tidy;
import javax.xml.xpath.*;
import java.util.*; 
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;

public class DiningHall { 
/*
    private static String getUrlSource(String url) throws IOException {
	URL menupage = new URL(url);
	URLConnection menupageconnection = menupage.openConnection();
	/*
	BufferedReader in = new BufferedReader(new InputStreamReader(
	    menupageconnection.getInputStream(), "UTF-8"));
	String inputLine;
	StringBuilder a = new StringBuilder();
	while ((inputLine = in.readLine()) != null)
	a.append(inputLine);
	in.close();

	return a.toString();
*/
/*
	InputStream is = menupageconnection.getInputStream();
	is = menupageconnection.openStream();
	Tidy tidy = new Tidy();
	tidy.setQuiet(true);
	tidy.setShowWarnings(false);
    }
    public static void main(String[] args) { 
	String url;
	url = "http://menu.ha.ucla.edu/foodpro/default.asp";
	Tidy tidy = new Tidy();
	try {
        	tidy.parse(getUrlSource(url), System.out);
	}
	catch(IOException e) {
		System.err.println("Caught IOException: "+e.getMessage());
	}
    }
*/
	public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer = tf.newTransformer();
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	    transformer.transform(new DOMSource(doc), 
		 new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	}
	public static void main(String[] args) throws Exception {
	    // Create a new JTidy instance and set options
	    Tidy tidy = new Tidy();
	    tidy.setXHTML(true); 
	    tidy.setQuiet(true);

	    // Parse an HTML page into a DOM document
	    URL url = new URL("http://menu.ha.ucla.edu/foodpro/default.asp");
	    Document doc = tidy.parseDOM(url.openStream(), System.out);
	
	    // Print the fixed xhtml
	    //printDocument(doc, System.out);

	    // Use XPath to obtain whatever you want from the (X)HTML
	    XPath xpath = XPathFactory.newInstance().newXPath();
	    XPathExpression expr = xpath.compile("//a[@class = 'itemlink']/text() | //a[@class = 'itemlinkt']/text()");
	    NodeList nodes = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
	    List<String> dishlist = new ArrayList<String>();
	    for (int i = 0; i < nodes.getLength(); i++) {
		dishlist.add(nodes.item(i).getNodeValue()); 
	    }
	    System.out.println(dishlist);


	}
}
