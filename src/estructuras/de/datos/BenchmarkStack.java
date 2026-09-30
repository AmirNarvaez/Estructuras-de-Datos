package estructuras.de.datos;

public class BenchmarkStack {

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

            MyStackArray<Integer> stack =
                    new MyStackArray<>();

            for (int j = 0; j < 10000; j++) {
                stack.push(j);
            }
        }

        System.out.println("===== MY STACK ARRAY =====");
        System.out.println();

        for (int size : sizes) {

            System.out.println("----- Tamaño: " + size + " -----");

            long totalPush = 0;

            for (int r = 0; r < 5; r++) {
                MyStackArray<Integer> stack =
                        new MyStackArray<>();

                totalPush += exec(size, stack::push);
            }

            System.out.println("push: " + (totalPush / 5) + " ns");


            long totalPop = 0;

            for (int r = 0; r < 5; r++) {
                MyStackArray<Integer> stack =
                        new MyStackArray<>();

                for (int i = 0; i < size; i++) {
                    stack.push(i);
                }

                totalPop += exec(size, i -> stack.pop());
            }

            System.out.println("pop: " + (totalPop / 5) + " ns");


            long totalPeek = 0;

            for (int r = 0; r < 5; r++) {
                MyStackArray<Integer> stack =
                        new MyStackArray<>();

                for (int i = 0; i < size; i++) {
                    stack.push(i);
                }

                totalPeek += exec(size, i -> stack.peek());
            }

            System.out.println("peek: " + (totalPeek / 5) + " ns");


            long totalIsEmpty = 0;

            for (int r = 0; r < 5; r++) {
                MyStackArray<Integer> stack =
                        new MyStackArray<>();

                totalIsEmpty += exec(size, i -> stack.isEmpty());
            }

            System.out.println("isEmpty: " + (totalIsEmpty / 5) + " ns");


            long totalSize = 0;

            for (int r = 0; r < 5; r++) {
                MyStackArray<Integer> stack =
                        new MyStackArray<>();

                for (int i = 0; i < size; i++) {
                    stack.push(i);
                }

                totalSize += exec(size, i -> stack.size());
            }

            System.out.println("size: " + (totalSize / 5) + " ns");


            long totalDelete = 0;

            for (int r = 0; r < 5; r++) {
                MyStackArray<Integer> stack =
                        new MyStackArray<>();

                for (int i = 0; i < size; i++) {
                    stack.push(i);
                }

                totalDelete += exec(size, i -> stack.delete(i));
            }

            System.out.println("delete: " + (totalDelete / 5) + " ns");

            System.out.println();
        }
    }
}