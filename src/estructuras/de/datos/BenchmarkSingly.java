package estructuras.de.datos;

public class BenchmarkSingly {

    public static long exec(int size, Operation operation) {

        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            operation.apply(i);
        }

        long finish = System.nanoTime();

        return finish - start;
    }

    public static void main(String[] args) {

        int[] sizes = {
            10,
            100,
            1000,
            10000,
            100000
        };

        // Calentamiento
        for (int i = 0; i < 3; i++) {

            SinglyLinkedList<Integer> lista =
                    new SinglyLinkedList<>();

            for (int j = 0; j < 10000; j++) {
                lista.pushFront(j);
            }
        }

        System.out.println("===== SINGLY LINKED LIST SIN TAIL =====");
        System.out.println();

        for (int size : sizes) {

            System.out.println("----- Tamaño: " + size + " -----");

            // PUSH FRONT
            long totalPushFront = 0;

            for (int r = 0; r < 5; r++) {

                SinglyLinkedList<Integer> lista =
                        new SinglyLinkedList<>();

                totalPushFront += exec(
                        size,
                        lista::pushFront
                );
            }

            System.out.println(
                    "pushFront: " + (totalPushFront / 5) + " ns"
            );


            // PUSH BACK
            long totalPushBack = 0;

            for (int r = 0; r < 5; r++) {

                SinglyLinkedList<Integer> lista =
                        new SinglyLinkedList<>();

                totalPushBack += exec(
                        size,
                        lista::pushBack
                );
            }

            System.out.println(
                    "pushBack: " + (totalPushBack / 5) + " ns"
            );


            // POP FRONT
            long totalPopFront = 0;

            for (int r = 0; r < 5; r++) {

                SinglyLinkedList<Integer> lista =
                        new SinglyLinkedList<>();

                for (int i = 0; i < size; i++) {
                    lista.pushFront(i);
                }

                totalPopFront += exec(
                        size,
                        i -> lista.popFront()
                );
            }

            System.out.println(
                    "popFront: " + (totalPopFront / 5) + " ns"
            );


            // POP BACK
            long totalPopBack = 0;

            for (int r = 0; r < 5; r++) {

                SinglyLinkedList<Integer> lista =
                        new SinglyLinkedList<>();

                for (int i = 0; i < size; i++) {
                    lista.pushFront(i);
                }

                totalPopBack += exec(
                        size,
                        i -> lista.popBack()
                );
            }

            System.out.println(
                    "popBack: " + (totalPopBack / 5) + " ns"
            );


            // FIND
            long totalFind = 0;

            for (int r = 0; r < 5; r++) {

                SinglyLinkedList<Integer> lista =
                        new SinglyLinkedList<>();

                for (int i = 0; i < size; i++) {
                    lista.pushFront(i);
                }

                totalFind += exec(
                        size,
                        i -> lista.find(i)
                );
            }

            System.out.println(
                    "find: " + (totalFind / 5) + " ns"
            );


            // ERASE
            long totalErase = 0;

            for (int r = 0; r < 5; r++) {

                SinglyLinkedList<Integer> lista =
                        new SinglyLinkedList<>();

                for (int i = 0; i < size; i++) {
                    lista.pushFront(i);
                }

                totalErase += exec(
                        size,
                        i -> lista.erase(i)
                );
            }

            System.out.println(
                    "erase: " + (totalErase / 5) + " ns"
            );


            // ADD BEFORE
            long totalAddBefore = 0;

            for (int r = 0; r < 5; r++) {

                SinglyLinkedList<Integer> lista =
                        new SinglyLinkedList<>();

                for (int i = 0; i < size; i++) {
                    lista.pushFront(i);
                }

                totalAddBefore += exec(
                        size,
                        i -> lista.addBefore(i, -i)
                );
            }

            System.out.println(
                    "addBefore: " + (totalAddBefore / 5) + " ns"
            );


            // ADD AFTER
            long totalAddAfter = 0;

            for (int r = 0; r < 5; r++) {

                SinglyLinkedList<Integer> lista =
                        new SinglyLinkedList<>();

                for (int i = 0; i < size; i++) {
                    lista.pushFront(i);
                }

                totalAddAfter += exec(
                        size,
                        i -> lista.addAfter(i, -i)
                );
            }

            System.out.println(
                    "addAfter: " + (totalAddAfter / 5) + " ns"
            );

            System.out.println();
        }
    }
}
