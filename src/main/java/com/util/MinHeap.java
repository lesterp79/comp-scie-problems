package com.util;

public class MinHeap implements Comparable<MinHeap> {

    public int data;
    public int heapIndex;
    public int currentIndex;

    public MinHeap(int data, int heapIndex, int currentIndex) {
        this.data = data;
        this.heapIndex = heapIndex;
        this.currentIndex = currentIndex;
    }


    @Override
    public String toString() {
        return data + "";
    }

    @Override
    public int compareTo(MinHeap o) {
        return Integer.compare(this.data, o.data);
    }


    // removes the minimum element from the heap, O(log n)
    public static void heapify(MinHeap[] heap, int root, int len) {

        int smallest = root;
        int leftIndex = left(root);
        int rightIndex = right(root);

        if (leftIndex < len && heap[smallest].data > heap[leftIndex].data) {
            smallest = leftIndex;
        }

        if (rightIndex < len && heap[smallest].data > heap[rightIndex].data) {
            smallest = rightIndex;
        }

        // swap smallest with root
        if (smallest != root) {
            swap(heap, smallest, root);
            heapify(heap, smallest, len);
        }
    }

    private static void swap(MinHeap[] heap, int i, int j) {
        MinHeap aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    // to get index of left child of node at index i
    private static int left(int i) {
        return (2 * i + 1);
    }

    // to get index of right child of node at index i
    private static int right(int i) {
        return (2 * i + 2);
    }

}
