import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void testStudents() {
        Student student1 = new Student("Name1", "Surname1", "1");
        Student student2 = new Student("Name2", "Surname2", "2");
        Student student3 = new Student("Name3", "Surname3", "3");

        System.out.println(Student.counter);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }

    public static void testFileUtils() throws IOException {
        FileUtil.createFile("Kraken");
        FileUtil.writeIntoFile("Kraken", "Kraken Is A Legendary Sea Monster");
        FileUtil.readFromFile("Kraken");
        FileUtil.deleteFile("Kraken");
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
//        testStudents();
//        testFileUtils();

        XMLUtil.createXML("students");
        List<Student> students = XMLUtil.parseXML("students");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
