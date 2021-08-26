/*class DynamicArray<T>{
    T[] arr;
    int size;
    int capacity;
    final int FACTOR_RESIZING = 2;

    public DynamicArray(){
        this.arr = (T[]) new Object[2];
        this.size = 0;
        this.capacity = 2;
    }

    void pushBack(T X){
        if(size == capacity){ //En este caso es O(n)
            T[] aux = (T[]) new Object[capacity*FACTOR_RESIZING];
            for(int i = 0; i < arr.length; i++)
                aux[i] = (T) arr[i];
            arr = aux;
            capacity *= FACTOR_RESIZING;
        }//O(1)
        arr[size++] = X;
    }

    //void remove(int i){

    //}
}

class Main{
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.pushBack(2);
        dynamicArray.pushBack(3);
        dynamicArray.pushBack(4);
        dynamicArray.pushBack(8);
        dynamicArray.pushBack(-15);
        dynamicArray.pushBack(3);
    }
}*/