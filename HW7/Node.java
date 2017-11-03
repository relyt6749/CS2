import java.util.NoSuchElementException;
import java.util.Scanner;

class Node<T> {

    public Node<T> next;
    public T data;

    public Node() {

    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [next=" + next + ", data=" + data + "]";
    }
}