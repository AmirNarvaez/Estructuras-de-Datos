package estructuras.de.datos;

public class MyQueueArray<T> implements MyQueue<T> {

    private T[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyQueueArray() {
        capacity = 10;
        data = (T[]) new Object[capacity];

        front = 0;
        rear = 0;
        size = 0;
    }
    
    private void resize() {
        int oldCapacity = capacity;
        capacity = capacity * 2;

        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % oldCapacity];
        }

        data = newData;
        front = 0;
        rear = size;
    }    
    
    @Override
    public void enqueue(T x) {
        if (size == capacity) {
            resize();
        }

        data[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }    

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T value = data[front];

        data[front] = null;
        front = (front + 1) % capacity;
        size--;

        return value;
    }    
    @Override
    public T front() {
        if (isEmpty()) {
            return null;
        }

        return data[front];
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
        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            if (data[index].equals(n)) {

                for (int j = i; j < size - 1; j++) {
                    int currentIndex = (front + j) % capacity;
                    int nextIndex = (front + j + 1) % capacity;

                    data[currentIndex] = data[nextIndex];
                }

                rear = (rear - 1 + capacity) % capacity;
                data[rear] = null;
                size--;

                return;
            }
        }
    }
}