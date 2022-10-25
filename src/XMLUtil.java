import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLUtil {

    public static void createXML(String filename) throws ParserConfigurationException, TransformerException {
        filename = filename.endsWith("xml") ? filename : (filename + ".xml");
        Document doc = DocumentBuilderFactory
                       .newInstance()
                       .newDocumentBuilder()
                       .newDocument();

        DOMSource domSource = new DOMSource(doc);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");

        Element students = doc.createElement("students");
        for (int i = 1; i < 6; i++) {
            String fname = "Name " + i;
            String lname = "Lastname " + i;
            String group = String.valueOf(i);

            Element student = doc.createElement("student");
            student.setAttribute("Group", group);

            Element firstName = doc.createElement("firstname");
            firstName.appendChild(doc.createTextNode(fname));

            Element lastName = doc.createElement("lastname");
            lastName.appendChild(doc.createTextNode(lname));

            student.appendChild(firstName);
            student.appendChild(lastName);

            students.appendChild(student);
        }
        doc.appendChild(students);

        StreamResult result = new StreamResult(new File(filename));
        transformer.transform(domSource, result);
    }

    public static List<Student> parseXML(String filename) throws ParserConfigurationException, IOException, SAXException {
        filename = filename.endsWith("xml") ? filename : (filename + ".xml");
        Document doc = DocumentBuilderFactory.newInstance()
                      .newDocumentBuilder()
                      .parse(new File(filename));
        doc.normalizeDocument();

        NodeList students = doc.getElementsByTagName("student");
        List<Student> studentsArray = new ArrayList<>();
        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            String group = student.getAttribute("Group");
            String fname = student.getElementsByTagName("firstname").item(0).getTextContent().trim();
            String lname = student.getElementsByTagName("lastname").item(0).getTextContent().trim();
            studentsArray.add(
                new Student(fname, lname, group)
            );
        }
        return studentsArray;
    }
}
