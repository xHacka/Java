import java.io.*;
import java.util.Scanner;

public class FileUtil {

    public static void createFile(String filename) throws IOException {
        File file = new File(filename + ".txt");
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("File Has Been Created Successfully");
            } else {
                System.out.println("Failed To Create New File");
            }
        } else {
            System.out.println("File Doesn't Exist");
        }
    }

    public static void writeIntoFile(String filename, String text) throws IOException {
        File file = new File(filename + ".txt");
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        System.out.println("Text Has Been Successfully Been Written Into File");
        writer.close();
    }

    public static void readFromFile(String filename) throws IOException {
        File file = new File(filename + ".txt");
//        FileReader reader = new FileReader(file);
//        int content;
//        while ((content = reader.read()) != -1) { // -1 => EOF
//            System.out.print((char) content);
//        }

        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String text = input.nextLine();
            System.out.println(text);
        }
        input.close();
    }

    public static void deleteFile(String filename) {
        File file = new File(filename + ".txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File Has Been Deleted Successfully");
            } else {
                System.out.println("Failed To Delete File");
            }
        } else {
            System.out.println("File Doesn't Exist");
        }
    }
}
