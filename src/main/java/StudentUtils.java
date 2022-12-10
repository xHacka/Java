import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentUtils {

    public StudentUtils() {

    }

    public static void createTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS students (
                    id INT NOT NULL AUTO_INCREMENT,
                    first_name VARCHAR(64) NOT NULL,
                    last_name VARCHAR(64) NOT NULL,
                    year INT(4) NOT NULL,
                    PRIMARY KEY (id),
                    UNIQUE KEY (id)
                )
                """;
        try {
            JDBCUtil.getStatement().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Table students Created Successfully");
    }

    public static void insert(Student student) {
        String query = String.format("""
                INSERT INTO students (first_name, last_name, year)
                VALUES ("%s", "%s", %d);
                """, student.getFirstname(), student.getLastname(), student.getYear());
        try {
            JDBCUtil.getStatement().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Record Successfully Inserted");
    }

    public static Student getStudent(long id) {
        String query = String.format("""
                SELECT * FROM students
                WHERE id=%d
                """, id);
        Student student = null;
        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(query);
            if (resultSet.next()) {
                student = new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("year")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    public static Student getStudentByFirstName(String fName) {
        String query = String.format("""
                SELECT * FROM students
                WHERE first_name="%s"
                """, fName);
        Student student = null;
        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(query);
            if (resultSet.next()) {
                student = new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("year")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    public static Student getStudentByLastName(String lName) {
        String query = String.format("""
                SELECT * FROM students
                WHERE last_name="%s"
                """, lName);
        Student student = null;
        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(query);
            if (resultSet.next()) {
                student = new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("year")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    public static Student getStudentByYear(int year) {
        String query = String.format("""
                SELECT * FROM students
                WHERE year=%d
                """, year);
        Student student = null;
        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(query);
            if (resultSet.next()) {
                student = new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("year")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    public static List<Student> getAll() {
        String query = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();

        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(query);
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("year")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public static void updateStudent(long id, String fName, String lName, int year) {
        String query = String.format("""
                UPDATE students
                SET first_name="%s"
                SET last_name="%s"
                SET year=%d
                WHERE id = %d
                """, fName, lName, year, id);
        Student student = null;
        try {
            JDBCUtil.getStatement().execute(query);
            student = getStudent(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (student != null) {
            System.out.printf(
                    "ID: %d Successfully Updated. [ %s -> %s, %s -> %s, %d -> %d ]\n",
                    id,
                    student.getFirstname(), fName,
                    student.getLastname(), lName,
                    student.getYear(), year
            );
        }
    }

    public static void updateStudentFirstname(long id, String fName) {
        String query = String.format("""
                UPDATE students
                SET first_name="%s"
                WHERE id = %d
                """, fName, id);
        Student student = null;
        try {
            student = getStudent(id);
            JDBCUtil.getStatement().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (student != null) {
            System.out.printf(
                    "ID: %d Successfully Updated. [ %s -> %s ]\n",
                    id, student.getFirstname(), fName
            );
        }

    }

    public static void updateStudentLastname(long id, String lName) {
        String query = String.format("""
                UPDATE students
                SET last_name="%s"
                WHERE id = %d
                """, lName, id);
        Student student = null;
        try {
            JDBCUtil.getStatement().execute(query);
            student = getStudent(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (student != null) {
            System.out.printf(
                    "ID: %d Successfully Updated. [ %s -> %s ]\n",
                    id, student.getLastname(), lName
            );
        }
    }

    public static void updateStudentYear(long id, int year) {
        String query = String.format("""
                UPDATE students
                SET year=%d
                WHERE id = %d
                """, year, id);
        Student student = null;
        try {
            JDBCUtil.getStatement().execute(query);
            student = getStudent(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (student != null) {
            System.out.printf(
                    "ID: %d Successfully Updated. [ %d -> %d ]\n",
                    id, student.getYear(), year
            );
        }
    }

    public static void deleteStudent(long id) {
        String query = String.format("""
                DELETE FROM students
                WHERE id = %d
                """, id);
        Student student = null;
        try {
            student = getStudent(id);
            JDBCUtil.getStatement().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s Deleted\n", student);
    }

    public static void deleteAllStudents() {
        String query = "DELETE FROM students";
        String resetIndex = "ALTER TABLE students AUTO_INCREMENT = 1";
        try {
            JDBCUtil.getStatement().execute(query);
            JDBCUtil.getStatement().execute(resetIndex);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All Students Deleted!");
    }

    public static List<Student> genDummyData() {
        // Dummy Data
        List<List<String>> studentsData = new ArrayList<>(
                List.of(
                        List.of("Kristofer", "Latey", "2008"),
                        List.of("Leanora", "Emmett", "2005"),
                        List.of("Myer", "Waber", "2000"),
                        List.of("Perla", "Lippatt", "1999"),
                        List.of("Reinald", "Gurg", "1999"),
                        List.of("Torry", "Muselli", "1987"),
                        List.of("Roddy", "Densey", "2007"),
                        List.of("Sheilakathryn", "England", "2002"),
                        List.of("Mabelle", "Kivelhan", "2003"),
                        List.of("Meade", "MacGlory", "2006")
                )
        );

        // Create student Objects From Data
        List<Student> students = new ArrayList<>();
        studentsData.forEach(studentData -> {
            students.add(
                    new Student(
                            studentData.get(0),
                            studentData.get(1),
                            Integer.valueOf(studentData.get(2))
                    ));
        });

        return students;
    }
}
