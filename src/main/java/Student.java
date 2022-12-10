public class Student {
    private Long id;
    private String firstname;
    private String lastname;
    private Integer year;

    public Student() {}

    public Student(String firstname, String lastname, Integer year) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.year = year;
    }

    public Student(Long id, String firstname, String lastname, Integer year) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format(
                "Student{id=%d, firstname=%s, lastname=%s, year=%d}",
                id, firstname, lastname, year
        );
    }
}
