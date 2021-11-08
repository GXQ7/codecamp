import java.util.*;


public class Hash_Set {

    public static void main(String[] args){

        Set<Student> studentRecords = new HashSet<Student>();
        studentRecords.add(new Student(24, "Dennis"));
        studentRecords.add(new Student(24, "Aluxx"));   //Duplicate key won't be added 
        studentRecords.add(new Student(25, "Peanut"));
        studentRecords.add(new Student(27, "Carlos"));

        Iterator<Student> i = studentRecords.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }


    }

}
