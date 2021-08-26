class UnderflowException extends  Exception{
    public UnderflowException(String message){           
        super(message);
    }
}

class Heap <T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 15;

    private int currentSize;
    private T[] array;

    public Heap(){
        this(DEFAULT_CAPACITY);
    }

    public Heap(int capacity){
        currentSize = 0;
        array = (T[]) new Comparable[capacity + 1];
    }

    public void insert(T aux){
        if(currentSize == array.length -1){
            enlargeArray(array.length * 2 + 1 );
        }

        //Percolate up
        int hole = ++currentSize;
        for(array[0] = aux; aux.compareTo(array[hole/2]) <0; hole/=2){
            array[hole] = array[hole/2];
        }
        array[hole] = aux;
    }

    private void enlargeArray(int newLength){
        T[] newArray; 
        newArray = (T[])new Comparable[newLength];
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean isEmpty(){
        if(array[1] == null){
            return true;
        }
        return false;
    }

    public T findMin() throws UnderflowException{
        if(isEmpty()){
            throw new UnderflowException(null);
        }
        return array[1];
    }

    public T deleteMin() throws UnderflowException{
        if(isEmpty()){
            throw new UnderflowException(null);
        }
        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    private void percolateDown(int hole){
        int child;
        T temp = array[hole];
        for(; hole * 2 <= currentSize; hole = child){
            child = hole *2;
            if(child != currentSize && array[child+1].compareTo(array[child])<0){
                child++;
            }
            if(array[child].compareTo(temp) <0){
                array[hole] = array[child];
            }else{
                break;
            }
        }
        array[hole] = temp;
    }

    public void inorder(){
        this.auxInorder(1);
    }

    private void auxInorder(int child){
        if(array[child] != null){
            this.auxInorder(2*child);
            System.out.print(array[child] + " ");
            this.auxInorder(2*child+1);
        }
    }
}

public class BinaryHeap{
    public static void main(String[] args) throws UnderflowException{
        Heap<Integer> cola = new Heap<>();
        cola.insert(1);
        cola.insert(2);
        cola.insert(3);
        cola.insert(4);
        cola.insert(5);
        cola.insert(6);
        cola.insert(7);


        cola.inorder();
        System.out.println();

        cola.deleteMin();
        cola.insert(8);

        cola.inorder();
    }
}