public class Road implements Comparable<Road>{
    
    private int miles;
    private String name;

    public Road(String name, int miles){
        this.name = name;
        this.miles = miles;
    }

    @Override
    public int compareTo(Road s) { 
       if (miles < s.miles)
       return -1;
       else if (miles > s.miles)
       return 1;
       return 0;
    }

    @Override
    public String toString() {
        return name + " is " + miles + "from tesco";
    }
}