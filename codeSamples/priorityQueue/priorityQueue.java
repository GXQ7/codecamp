import java.util.*;

public class priorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Student> studentQ = new PriorityQueue<Student>( );
        studentQ.add(new Student("Joanne", 6));
        studentQ.add(new Student("Grace", 7));
        studentQ.add(new Student("Eimear", 12));
        studentQ.add(new Student("Megan", 1));
        
        System.out.println("Size of Queue: " + studentQ.size());
        Iterator i = studentQ.iterator();

        while(i.hasNext()){
            System.out.println(studentQ.poll());
        }
    }

}
