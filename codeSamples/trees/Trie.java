import java.util.ArrayList;

/**
 *  A basic implementation of a trie, utilizing the lowercase english alphabet
 *  Supported Operations: Insert, Search, Starts With
 * 
 */

public class Trie {
    Node root;

    Trie(){
        //dummy node
        root = new Node('\0');  //empty character
    }

    private class Node {
        char key;
        boolean isWord;
        Node[] children;  

        Node(Character key){
            this.key = key;
            isWord = false;
            this.children = new Node[26];  
        }
    }

    public void insert(String word){
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //checking associated index for character
            // index is calculated by taking aay the decimal value of a
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new Node(c);

            //character has been inserted - update current to reflect change
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    //return true if the word exists in the trie
    public boolean search(String word){
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    //return true if there is a word in the trie beginning with the given prefix
    public boolean startsWith(String prefix){
        return getNode(prefix) != null;
    }

    private Node getNode(String word){
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // charcater doesn't exist
            if (current.children[c - 'a'] == null) return null;
            //update current
            current = current.children[c - 'a'];
        }
        //return the end node of the word
        return current;
    }
}