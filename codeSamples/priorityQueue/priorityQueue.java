import java.util.*;

public class priorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Road> roads = new PriorityQueue<Road>( );
        roads.add(new Road("Smithdown Road", 3));
        roads.add(new Road("Lesuirely Way", 4));
        roads.add(new Road("Quick Avenue", 2));


        System.out.println("Number of roads: " + roads.size());
        Iterator i = roads.iterator();

        while(i.hasNext()){
            System.out.println(roads.poll().toString());
        }
    }

}
