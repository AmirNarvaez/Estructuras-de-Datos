package estructuras.de.datos;

public class DoublyLinkedList<T> {

    private DoublyNode<T> head;
    private int size;

    public DoublyLinkedList() {
        head = null;
        size = 0;
    }

    public void pushFront(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);

        newNode.next = head;

        if (head != null) {
            head.previous = newNode;
        }

        head = newNode;

        size++;
    }
    
    public void pushBack(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        DoublyNode<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.previous = current;

        size++;
    }
    
    public void popFront() {
        if (head == null) {
            return;
        }

        head = head.next;

        if (head != null) {
            head.previous = null;
        }

        size--;
    }    
    
    public void popBack() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        DoublyNode<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.previous.next = null;

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

            if (head != null) {
                head.previous = null;
            }

            size--;
            return;
        }

        DoublyNode<T> current = head.next;

        while (current != null) {
            if (current.data.equals(dato)) {

                current.previous.next = current.next;

                if (current.next != null) {
                    current.next.previous = current.previous;
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
