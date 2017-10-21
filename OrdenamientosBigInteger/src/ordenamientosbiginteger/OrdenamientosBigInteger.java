/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientosbiginteger;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Fabian Osorio
 */
public class OrdenamientosBigInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random random = new Random();
        long totalTiempo;
        long tiempoInicio;
        BigInteger Arreglo[] = new BigInteger[2000];
        for (int i = 0; i < 2000; i++) {
            double p;
            BigInteger s = new BigInteger("999999999999999");
            BigInteger t = new BigInteger("10000000000000");
            BigInteger Aleatorio = new BigInteger(45, random);
            while (t.compareTo(Aleatorio) >= 0 || s.compareTo(Aleatorio) <= 0) {
                Aleatorio = new BigInteger(45, random);
            }
            Arreglo[i] = Aleatorio;
        }
        BigInteger Arreglobubble[] = Arrays.copyOf(Arreglo, Arreglo.length);
        BigInteger Arregloinsert[] = Arrays.copyOf(Arreglo, Arreglo.length);
        BigInteger Arregloselect[] = Arrays.copyOf(Arreglo, Arreglo.length);
        BigInteger Arregloquick[] = Arrays.copyOf(Arreglo, Arreglo.length);
        BigInteger Arreglomerge[] = Arrays.copyOf(Arreglo, Arreglo.length);
        BigInteger Arregloshell[] = Arrays.copyOf(Arreglo, Arreglo.length);
        BigInteger Arregloheap[] = Arrays.copyOf(Arreglo, Arreglo.length);
        tiempoInicio = System.nanoTime();
        long iteracionesbubble = 0;
        Arreglobubble = bubbleSort(Arreglobubble, iteracionesbubble);
        totalTiempo = System.nanoTime();
        long tiempoBubbleSort = totalTiempo - tiempoInicio;
        System.out.println("tiempo del bubbleSort: " + tiempoBubbleSort);
        tiempoInicio = System.nanoTime();
        long iteracionesinsert = 0;
        Arregloinsert = insertionSort(Arregloinsert, iteracionesinsert);
        totalTiempo = System.nanoTime();
        long tiempoInsertSort = totalTiempo - tiempoInicio;
        System.out.println("tiempo del InsertSort: " + tiempoInsertSort);
        tiempoInicio = System.nanoTime();
        long iteracionesselect = 0;
        Arregloselect = SelectSort(Arregloinsert, iteracionesselect);
        totalTiempo = System.nanoTime();
        long tiempoSelectSort = totalTiempo - tiempoInicio;
        System.out.println("tiempo del SelectSort: " + tiempoSelectSort);
        tiempoInicio = System.nanoTime();
        long iteracionesquick = 0;
        Quicksort(Arregloquick, 0, 1999, iteracionesquick);
        totalTiempo = System.nanoTime();
        long tiempoQuickSort = totalTiempo - tiempoInicio;
        System.out.println("iteraciones del QuickSort:" + iteracionesquick);
        System.out.println("tiempo del QuickSort: " + tiempoQuickSort);
        tiempoInicio = System.nanoTime();
        long iteracionesmerge = 0;
        MergeSort(Arreglomerge, 0, 1999);
        totalTiempo = System.nanoTime();
        long tiempoMergeSort = totalTiempo - tiempoInicio;
        System.out.println("iteraciones del MergeSort:" + iteracionesmerge);
        System.out.println("tiempo del MergeSort: " + tiempoMergeSort);
        tiempoInicio = System.nanoTime();
        long iteracionesshell = 0;
        ShellSort(Arregloshell, iteracionesshell);
        totalTiempo = System.nanoTime();
        long tiempoShellSort = totalTiempo - tiempoInicio;

        System.out.println("tiempo del ShellSort: " + tiempoShellSort);
        tiempoInicio = System.nanoTime();
        long iteracionesheap = 0;
        HeapSort(Arregloheap);
        totalTiempo = System.nanoTime();
        long tiempoHeapSort = totalTiempo - tiempoInicio;
        System.out.println("iteraciones del HeapSort:" + iteracionesheap);
        System.out.println("tiempo del HeadSort: " + tiempoHeapSort);
        //tiempoInicio = System.nanoTime();
        //long iteracionesradix = 0;
        //radixsort(Arregloradix);
        //totalTiempo = System.nanoTime();
        //long tiemporadixSort = totalTiempo - tiempoInicio;
        //System.out.println("iteraciones del RadixSort:" + iteracionesradix);
        //System.out.println("tiempo del RadixSort: " + tiemporadixSort);
    }

    static BigInteger[] bubbleSort(BigInteger[] arr, long iteracionesbubble) {
        int n = arr.length;
        BigInteger temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                iteracionesbubble++;
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    //swap elements  
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("iteraciones del bubbleSort:" + iteracionesbubble);
        return arr;

    }

    static BigInteger[] insertionSort(BigInteger[] arr, long iteraciones) {
        int i, j;
        BigInteger newValue;
        for (i = 1; i < arr.length; i++) {
            newValue = arr[i];
            j = i;
            iteraciones++;
            boolean sw = false;
            while (j > 0 && arr[j - 1].compareTo(newValue) > 0) {
                if (sw) {
                    iteraciones++;
                } else {
                    sw = true;
                }
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = newValue;
        }
        System.out.println("iteraciones del InsertSort:" + iteraciones);
        return arr;
    }

    public static BigInteger[] SelectSort(BigInteger[] arr, long iteraciones) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                iteraciones++;
                if (arr[j].compareTo(arr[index]) < 0) {
                    index = j;
                }
            }

            BigInteger smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        System.out.println("iteraciones del SelectSort:" + iteraciones);
        return arr;
    }

    public static void Quicksort(BigInteger A[], int izq, int der, long iteraciones) {

        BigInteger pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        BigInteger aux;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (A[i].compareTo(pivote) <= 0 && i < j) {
                i++; // busca elemento mayor que pivote
                iteraciones++;
            }
            while (A[j].compareTo(pivote) > 0) {
                j--;         // busca elemento menor que pivote
                iteraciones++;
            }
            if (i < j) {                      // si no se han cruzado                      
                aux = A[i];                  // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            Quicksort(A, izq, j - 1, iteraciones); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            Quicksort(A, j + 1, der, iteraciones); // ordenamos subarray derecho
        }
    }

    public static void MergeSort(BigInteger A[], int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            MergeSort(A, izq, m);
            MergeSort(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }

    public static void merge(BigInteger A[], int izq, int m, int der) {
        int i, j, k;
        BigInteger B[] = new BigInteger[A.length];
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i].compareTo(B[j]) <= 0) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }

    public static void ShellSort(BigInteger A[], long iteraciones) {
        int salto, i;
        BigInteger aux;
        boolean cambios;
        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) { // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < A.length; i++) // se da una pasada
                {
                    if (A[i - salto].compareTo(A[i]) > 0) { // y si están desordenados
                        aux = A[i]; // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true; // y se marca como cambio.
                    }
                    iteraciones++;
                }
            }
        }
        System.out.println("iteraciones del ShellSort:" + iteraciones);
    }

    public static void HeapSort(BigInteger arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            BigInteger temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(BigInteger arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l].compareTo(arr[largest]) > 0) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r].compareTo(arr[largest]) > 0) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            BigInteger swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }
}
