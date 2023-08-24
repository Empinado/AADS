package AADS.hw1;

public class HW_1 {
    public static void sort(int[] array){
        //Перегруппировка массива методом кучи 
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        //Поочередно извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--){
            //пермещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[1];
            array[i] = temp;
            
            //вызываем процедуру heapify на уменшенной куче
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализация наибольшего элемента, как корень 
        int leftChild = 2 * rootIndex + 1; 
        int rightChild = 2 * rootIndex + 2;

        //Если левый дочерний элемент больше корня 
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        //Если правый дочерний эл больше, чем самый боьшой элемент на данный момент
        if (rightChild < heapSize && array[leftChild] > array[largest])
            largest = rightChild;

        //Если самый большой элемент на кроень 
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            //Преобразовываем в двоичную поддерево, при помощи рекурсии
            heapify(array, heapSize, largest);
        }
    }
}