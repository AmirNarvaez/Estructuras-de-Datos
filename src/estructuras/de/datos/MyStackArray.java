package estructuras.de.datos;

public class MyStackArray<T> implements MyStack<T> {
    private T[] data;
    private int top;
    private int size;
    private int capacity;

    public MyStackArray() {
        capacity = 10;
        data = (T[]) new Object[capacity];
        top = -1;
        size = 0;
    }
    
    private void resize() {
        capacity = capacity * 2;

        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }    
    
    @Override
    public void push(T x) {
        if (size == capacity) {
            resize();
        }

        top++;
        data[top] = x;
        size++;
    }
    
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T value = data[top];

        data[top] = null;
        top--;
        size--;

        return value;
    }
    
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return data[top];
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public int size() {
        return size;
    }    

    @Override
    public void delete(T n) {
        for (int i = 0; i <= top; i++) {
            if (data[i].equals(n)) {

                for (int j = i; j < top; j++) {
                    data[j] = data[j + 1];
                }

                data[top] = null;
                top--;
                size--;

                return;
            }
        }
    }    
}
