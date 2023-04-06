package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{
                4, 3, 5, 8, 1, 2, 9, 3, 6, 1, 6
        };
//        int[] array = new int[]{
//                1, 2, 3, 4, 5, 6, 7, 8, 9,
//        };
        System.out.print(Arrays.toString(array) + "\n");

        System.out.println(Arrays.toString(heapSort(array)));

//        System.out.print(Arrays.toString(quickSort(array, 0, array.length - 1)));
//
//        bubbleSort(array);
//        directSort(array);
//        insertSort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

//        int num = find(array, 8);
//        System.out.println(num);
    }

//    public static void quickSort(int[] array) {
//        quickSort(array, 0, array.length - 1);
//    }


    // Сортировка кучей
    public static int[] heapSort(int[] array) {
        //Построение кучи(перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heap(array, array.length, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;


            heap(array, i, 0);
        }
        return array;
    }

    public static void heap(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; //Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // Левый равно 2 * rootIndex + 1
        int rightChild = 2 * rootIndex + 2;// Правый равно 2 * rootIndex + 2

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heap(array, heapSize, largest);
        }

    }

    // Быстрая сортировка
    public static int[] quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }

        } while (leftPosition <= rightPosition);

        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
        return array;
    }


    // Бинарный поиск
    public static int binarySearch(int[] array, int value, int min, int max) {
        int mindpoint;
        if (max < min) {
            return -1;
        } else {
            mindpoint = (max - min) / 2 + min; // Делим пополам
        }

        if (array[mindpoint] < value) {
            return binarySearch(array, value, mindpoint + 1, max);
        } else {
            if (array[mindpoint] > value) {
                return binarySearch(array, value, min, mindpoint - 1);
            } else {
                return mindpoint;
            }
        }
    }

    // Простой поиск
    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Пузырьковая сортировка
    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);
    }

    // Сортировка выбором
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    // Сортировка вставками
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


}