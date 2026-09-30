package estructuras.de.datos;

public class SinglyLinkedListWithTail<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedListWithTail() {
        head = null;
        tail = null;
        size = 0;
    }

    public void pushFront(T data) {
    Node<T> newNode = new Node<>(data);

    newNode.next = head;
    head = newNode;

    if (tail == null) {
        tail = newNode;
    }

    size++;
    }
    
    public void pushBack(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }
    
    public void popFront() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }

        size--;
    }   
    
    public void popBack() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node<T> current = head;

        while (current.next != tail) {
            current = current.next;
        }

        current.next = null;
        tail = current;
        size--;
    }    
    
    public Node<T> find(T dato) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(dato)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }    

    public void erase(T dato) {
        if (head == null) {
            return;
        }

        if (head.data.equals(dato)) {
            head = head.next;

            if (head == null) {
                tail = null;
            }

            size--;
            return;
        }

        Node<T> previous = head;
        Node<T> current = head.next;

        while (current != null) {
            if (current.data.equals(dato)) {
                previous.next = current.next;

                if (current == tail) {
                    tail = previous;
                }

                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public void addBefore(T datoExistente, T nuevoDato) {
        if (head == null) {
            return;
        }

        if (head.data.equals(datoExistente)) {
            Node<T> newNode = new Node<>(nuevoDato);

            newNode.next = head;
            head = newNode;

            size++;
            return;
        }

        Node<T> previous = head;
        Node<T> current = head.next;

        while (current != null) {
            if (current.data.equals(datoExistente)) {
                Node<T> newNode = new Node<>(nuevoDato);

                newNode.next = current;
                previous.next = newNode;

                size++;
                return;
            }

            previous = current;
            current = current.next;
        }
    }   
    
    public void addAfter(T datoExistente, T nuevoDato) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(datoExistente)) {
                Node<T> newNode = new Node<>(nuevoDato);

                newNode.next = current.next;
                current.next = newNode;

                if (current == tail) {
                    tail = newNode;
                }

                size++;
                return;
            }

            current = current.next;
        }
    }  
    
    public boolean isEmpty() {
        return head == null;
    }
    
}


