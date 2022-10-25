public class Student {
    private String fname, lname, group;
    private static String university = "BTU";

    public static int counter = 0;

    static {
        System.out.println("Kraken (It's Because Of Default Static Method)");
    }
    public Student(String fname, String lname, String group) {
        this.fname = fname;
        this.lname = lname;
        this.group = group;
        counter++;
    }

    public static String getUniversity() {
        return university;
    }

    public String getFname() { return fname;}
    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    @Override
    public String toString() {
        return "Student{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
