public class Main{
    public static void Main(String[] args){
         //Java Deque interface
         Deque<String> webBrowserHistory = new ArrayDeque<String>();
         webBrowserHistory.add("a");
         webBrowserHistory.offerFirst("b");
         webBrowserHistory.offerFirst("c");
         webBrowserHistory.offerFirst("d");
 
         if (webBrowserHistory.size() >= 3)
         {
             // URL at the tail of the deque is removed after specified number of insertions
             webBrowserHistory.removeLast();
         }
    }
}