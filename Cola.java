
public class Cola<T> extends MySimpleLinkedList{
    public void enqueue(T data){
        super.insertBigin(data);
    }

    T dequeue(){
        T aux = (T)super.lastValue(); 
        super.deleteEnd();
        return aux;
    }

    T peek(){
        return (T)super.lastValue();
    }
}
