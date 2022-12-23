package utilities;

public class Node <T>{
    public T value;
    Node<T> next;
    Node<T> prev;   
    
    public Node(T val){
        value = val;
    }
}
