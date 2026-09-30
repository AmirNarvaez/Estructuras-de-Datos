package estructuras.de.datos;

public class BenchmarkQueue {

    public static long exec(int size, Operation operation) {

        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            operation.apply(i);
        }

        long finish = System.nanoTime();

        return finish - start;
    }

    public static void main(String[] args) {

        int[] sizes = {10, 100, 1000, 10000, 100000};

        // Calentamiento
        for (int i = 0; i < 3; i++) {

            MyQueueArray<Integer> queue =
                    new MyQueueArray<>();

            for (int j = 0; j < 10000; j++) {
                queue.enqueue(j);
            }
        }

        System.out.println("===== MY QUEUE ARRAY =====");
        System.out.println();

        for (int size : sizes) {

            System.out.println("----- Tamaño: " + size + " -----");

            long totalEnqueue = 0;

            for (int r = 0; r < 5; r++) {
                MyQueueArray<Integer> queue =
                        new MyQueueArray<>();

                totalEnqueue += exec(size, queue::enqueue);
            }

            System.out.println("enqueue: " + (totalEnqueue / 5) + " ns");


            long totalDequeue = 0;

            for (int r = 0; r < 5; r++) {
                MyQueueArray<Integer> queue =
                        new MyQueueArray<>();

                for (int i = 0; i < size; i++) {
                    queue.enqueue(i);
                }

                totalDequeue += exec(size, i -> queue.dequeue());
            }

            System.out.println("dequeue: " + (totalDequeue / 5) + " ns");


            long totalFront = 0;

            for (int r = 0; r < 5; r++) {
                MyQueueArray<Integer> queue =
                        new MyQueueArray<>();

                for (int i = 0; i < size; i++) {
                    queue.enqueue(i);
                }

                totalFront += exec(size, i -> queue.front());
            }

            System.out.println("front: " + (totalFront / 5) + " ns");


            long totalIsEmpty = 0;

            for (int r = 0; r < 5; r++) {
                MyQueueArray<Integer> queue =
                        new MyQueueArray<>();

                totalIsEmpty += exec(size, i -> queue.isEmpty());
            }

            System.out.println("isEmpty: " + (totalIsEmpty / 5) + " ns");


            long totalSize = 0;

            for (int r = 0; r < 5; r++) {
                MyQueueArray<Integer> queue =
                        new MyQueueArray<>();

                for (int i = 0; i < size; i++) {
                    queue.enqueue(i);
                }

                totalSize += exec(size, i -> queue.size());
            }

            System.out.println("size: " + (totalSize / 5) + " ns");


            long totalDelete = 0;

            for (int r = 0; r < 5; r++) {
                MyQueueArray<Integer> queue =
                        new MyQueueArray<>();

                for (int i = 0; i < size; i++) {
                    queue.enqueue(i);
                }

                totalDelete += exec(size, i -> queue.delete(i));
            }

            System.out.println("delete: " + (totalDelete / 5) + " ns");

            System.out.println();
        }
    }
}