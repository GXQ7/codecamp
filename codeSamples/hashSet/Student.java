

public class Student {

    private int studentNumber;
    private String name;

    public Student(int num, String name) {
        this.studentNumber = num;
        this.name = name;
    }


    @Override
    public int hashCode()
    {
        return studentNumber;
    }
 
    @Override
    public boolean equals(Object obj)
    {
        Student s = (Student) obj;
        return studentNumber == s.studentNumber;
    }
 
    @Override
    public String toString()
    {
        return studentNumber +", " + name;
    }

}
