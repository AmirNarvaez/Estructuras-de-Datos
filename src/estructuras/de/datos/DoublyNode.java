package estructuras.de.datos;

public class DoublyNode<T> {

    T data;
    DoublyNode<T> next;
    DoublyNode<T> previous;

    public DoublyNode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}