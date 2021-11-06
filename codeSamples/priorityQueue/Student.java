public class Student implements Comparable<Student>{
    
    private int ranking;
    private String name;

    public Student(String name, int ranking){
        this.name = name;
        this.ranking = ranking;
    }

    @Override
    public int compareTo(Student s) { 
       if (ranking < s.ranking)
       return -1;
       else if (ranking > s.ranking)
       return 1;
       return 0;
    }

    @Override
    public String toString() {
        return "Student: " + name + "\n Ranking: " + ranking;
    }
}