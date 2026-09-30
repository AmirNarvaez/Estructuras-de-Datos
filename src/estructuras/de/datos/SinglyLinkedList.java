package estructuras.de.datos;

public class SinglyLinkedList <T>{
    private Node<T> head;
    private int size;
    
    public SinglyLinkedList(){
        head = null;
        size = 0;
    }

    public void pushFront(T data){
        Node<T> newNode = new Node<>(data);
        
        newNode.next = head;
        head = newNode;

        size++;
    }
    
    public void pushBack (T data){
        Node<T> newNode = new Node<>(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        
        size ++;
    }
    
    public void popFront (){
        if (head != null){
            head = head.next;
            
            size --;
        } 
    }
    
    public void popBack (){
        if (head == null){
            return;
        }
        
        if (head.next == null){
            head = null;
            size --;
            return;
        }
        
        if (head != null){
        Node<T> current = head;
            while (current.next.next != null){
            current = current.next;
            }
            
            current.next = null;
            
            size --;
        }
    }
    
    public Node<T> find (T dato){
        Node<T> current = head;
        
        while (current != null){
            if (current.data.equals(dato)){
                return current;
            }
            current = current.next;
        }
        
        return null;
    }
    
    public void erase (T dato){
        if (head == null){
            return;
        }
        
        if (head.data.equals(dato)){
            head = head.next;
            size --;
            return;
        }
        
        Node<T> previous = head;
        Node<T> current = head.next;
        
        while (current != null){
            if (current.data.equals(dato)){
                previous.next = current.next;
                size --;
                return;
            }
            
            previous = current;
            current = current.next;
        }
    }
    
    public void addBefore (T datoExistente, T nuevoDato){
        if (head == null){
            return;
        }
        
        if (head.data.equals(datoExistente)){
            Node<T> newNode = new Node<>(nuevoDato);
            
            newNode.next = head;
            head = newNode;
            
            size ++;
            return;
        }
        
        Node<T> previous = head;
        Node<T> current = head.next;
        
        while (current != null){
            if (current.data.equals(datoExistente)){
                Node<T> newNode = new Node<>(nuevoDato);
            
                newNode = current;
                previous.next = newNode;
                
                size ++;
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
