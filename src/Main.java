import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Name1", "Lastname1", 1);
        Student s2 = new Student("Name2", "Lastname2", 2);
        Student s3 = new Student("Name3", "Lastname3", 3);
        Student s4 = new Student("Name4", "Lastname4", 4);

        // Different Methods Of Creating Streams
        // List<Student> students = Arrays.asList(s1, s2, s3);
        // Stream<Student> studentStream = students.stream();
        // Stream<Student> studentStreamAlternative = Stream.of(s1, s2, s3);
        // Stream<Student> streamBuilder = Stream.<Student>builder().add(s1).add(s2).add(s3).build();
        // Stream<String> stringStream = Stream.generate(() -> "NameGen").limit(10);

        Stream<Student> students = Stream.of(s1, s2, s3, s4); // **Streams Are 1 Time Use**
        List<Student> studentsFiltered = Stream.of(s1, s2, s3)
                .filter(student -> student.getId() >= 2) // `->` Lambda Function
                .toList(); // `Stream.filter` Returns `Stream`

        Stream.of(s1, s2, s3).map(student -> {
            student.setName("Cthulhu");
            return student; // Modified Object Should Be Returned In `map`
        }).forEach(System.out::println); // Class::Method (Uses Passed Params As Positional Arguments)

        // students
        // .filter(student -> student.getId() % 2 == 0)
        // .forEach(System.out::println);
    }

}
