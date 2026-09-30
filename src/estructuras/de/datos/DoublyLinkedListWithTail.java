package estructuras.de.datos;

public class DoublyLinkedListWithTail<T> {

    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    public DoublyLinkedListWithTail() {
        head = null;
        tail = null;
        size = 0;
    }

    public void pushFront(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);

        newNode.next = head;

        if (head != null) {
            head.previous = newNode;
        } else {
            tail = newNode;
        }

        head = newNode;

        size++;
    }

    public void pushBack(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void popFront() {
        if (head == null) {
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }

        size--;
    }

    public void popBack() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        tail = tail.previous;
        tail.next = null;

        size--;
    }

    public DoublyNode<T> find(T dato) {
        DoublyNode<T> current = head;

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
            } else {
                head.previous = null;
            }

            size--;
            return;
        }

        DoublyNode<T> current = head;

        while (current != null) {
            if (current.data.equals(dato)) {

                current.previous.next = current.next;

                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous;
                }

                size--;
                return;
            }

            current = current.next;
        }
    }
    
    public void addBefore(T datoExistente, T nuevoDato) {
        if (head == null) {
            return;
        }

        if (head.data.equals(datoExistente)) {
            DoublyNode<T> newNode = new DoublyNode<>(nuevoDato);

            newNode.next = head;
            head.previous = newNode;
            head = newNode;

            size++;
            return;
        }

        DoublyNode<T> current = head.next;

        while (current != null) {
            if (current.data.equals(datoExistente)) {
                DoublyNode<T> newNode = new DoublyNode<>(nuevoDato);

                newNode.next = current;
                newNode.previous = current.previous;

                current.previous.next = newNode;
                current.previous = newNode;

                size++;
                return;
            }

            current = current.next;
        }
    }    
    
    public void addAfter(T datoExistente, T nuevoDato) {
        DoublyNode<T> current = head;

        while (current != null) {
            if (current.data.equals(datoExistente)) {
                DoublyNode<T> newNode = new DoublyNode<>(nuevoDato);

                newNode.previous = current;
                newNode.next = current.next;

                current.next = newNode;

                if (newNode.next != null) {
                    newNode.next.previous = newNode;
                } else {
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
    
    public void print() {
        DoublyNode<T> current = head;

        while (current != null) {
            System.out.print(current.data + " ⇄ ");
            current = current.next;
        }

        System.out.println("null");
    }    
}