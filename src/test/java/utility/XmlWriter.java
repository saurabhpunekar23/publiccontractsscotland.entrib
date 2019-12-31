package utility;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.Reporter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlWriter {


public static void xmlWrite(String title, String referenceNo, String ocid, String publishedby,
String publicationDate,String mainContactEmail, String url) {

DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder;

try {
dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.newDocument();
//add elements to Document
Element rootElement = doc.createElementNS("https://www.publiccontractsscotland.gov.uk/", "Notices");
//append root element to document
doc.appendChild(rootElement);

//append first child element to root element
rootElement.appendChild(getNotice(doc, title, referenceNo,ocid,publishedby,publicationDate,mainContactEmail, url));


//for output to file, console
TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
//for pretty print
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
DOMSource source = new DOMSource(doc);

//to create new folder
String path = "XmlFiles";
new File(path).mkdirs();

//write to console or file
StreamResult console = new StreamResult(System.out);
StreamResult file = new StreamResult(new File("XMLFiles/"+referenceNo+".xml"));

//write data
transformer.transform(source, console);
transformer.transform(source, file);
Reporter.log("DONE");

} catch (Exception e) {
e.printStackTrace();
}
}


private static Node getNotice(Document doc, String title, String referenceNo, String ocid, String publishedby,
String publicationDate,String mainContactEmail,String url) {
Element contarct = doc.createElement("Notice");

//set title attribute
contarct.setAttribute("title", title);

//create referenceNo element
contarct.appendChild(getNoticeElements(doc, contarct, "referenceNo", referenceNo));

//create ocid element
contarct.appendChild(getNoticeElements(doc, contarct, "ocid", ocid));

//create publishedby element
contarct.appendChild(getNoticeElements(doc, contarct, "publishedby", publishedby));

//create publication date element
contarct.appendChild(getNoticeElements(doc, contarct, "publicationDate", publicationDate));

contarct.appendChild(getNoticeElements(doc, contarct, "mainContactEmail", mainContactEmail));

contarct.appendChild(getNoticeElements(doc, contarct, "url", url));

return contarct;
}


//utility method to create text node
private static Node getNoticeElements(Document doc, Element element, String name, String value) {
Element node = doc.createElement(name);
node.appendChild(doc.createTextNode(value));
return node;
}

}
