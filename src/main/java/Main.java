import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create students Table
        System.out.println("Creating Table...");
        StudentUtils.createTable();

        // Dummy Data
        List<Student> studentsData = StudentUtils.genDummyData();

        // Insert Into The Database
        System.out.println("\nInserting Data...");
        studentsData.forEach(StudentUtils::insert);

        // Get Students
        System.out.println("\nGetting All Student Data...");
        List<Student> students = StudentUtils.getAll();
        students.forEach(System.out::println);

        // Update student Name
        System.out.println("\nUpdating Name...");
        StudentUtils.updateStudentFirstname(3, "Bob");

        // Delete student
        System.out.println("\nDeleting Student...");
        StudentUtils.deleteStudent(3);

        // Delete All Students
        System.out.println("\nDeleting All Students...");
        StudentUtils.deleteAllStudents();
        System.out.println();
    }
}
