/*import java.io.*;

class Node<dataType>{
    dataType data;
    Node<dataType> next;
    Node<dataType> previous;

    public Node(dataType data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public dataType getData(){
        return data;
    }
}

class DoubleLinkedList<T>{
    Node<T> first;
    Node<T> last;
    Integer count;
    
    public DoubleLinkedList(){
        this.makeEmpty();
    }

    public void insertBegin(T insert){
        Node<T> newNode = new Node<>(insert);
        if(isEmpty()){
            this.first = newNode;
            this.last = newNode;
            this.count++;
            return;
        }
        this.first.previous = newNode;
        newNode.next = this.first;
        this.first = newNode;
        count++;
    }

    public void insertEnd(T insert){
        Node<T> newNode = new Node<>(insert);
        if(isEmpty()){
            insertBegin(insert);
            return;
        }
        this.last.next = newNode;
        newNode.previous = this.last;
        this.last = newNode;
        count++;
    }

    public boolean checklength(int index){
        if(0 <= index && index < count){
            return true;
        }
        return false;
    }

    public void length(){
        System.out.print(this.count);
    }

    public Node<T> read(int index){
        if(this.checklength(index)==false){
            System.out.print("Revise la longitud de la lista con length()");
            return null;
        }
        Node<T> aux = this.first;
        for(int i = 0; i<index; i++){
            aux = aux.next;
        }
        return aux;
    }

    public void insert(T insert, int index){
        
        if(this.checklength(index)==false){
            System.out.print("Revise la longitud de la lista con length()");
        }else if(index==0){
            insertBegin(insert);
            return;
        }else if(index==count-1){
            insertEnd(insert);
        }else{
            Node<T> newNode = new Node<>(insert), aux = this.read(index);
            newNode.previous = aux.previous;
            if(index==count){
                newNode.next=null;
            }else{
                newNode.next = aux;
            }
            aux.previous.next = newNode;
            aux.previous = newNode;
            count++;
        }
    }

    public void deleteBegin(){
        if(this.first.next == null){
            makeEmpty();
        }else{
            this.first = this.first.next;
            this.first.previous = null;
            this.count--;
        }
    }

    public void deleteEnd(){
        if(this.last.previous == null){
            makeEmpty();
        }else{
            this.last = this.last.previous;
            this.last.next = null;
            this.count--;
        }  
    }

    public void delete(int index){
        if(this.checklength(index)==false){
            System.out.print("Revise la longitud de la lista con length()");
        }else if(index==0){
            deleteBegin();
        }else if(index==count-1){
            deleteEnd();
        }else{
            Node<T> aux = this.read(index-1), axi = this.read(index), axo = this.read(index+1);
            aux.next = axi.next;
            axo.previous = axi.previous;
            this.count--;
        }
    }



    public int position(Integer insert){
        Node<T> aux = this.first;
        if(isEmpty()){
            System.out.println("Ese dato no se encuentra en la lista");
            return -1;
        }
        for(int i = 0; i<count; i++){
            if(aux.data==insert){
                return i;
            }
            aux = aux.next;
        }
        return 0;
    }

    public void change(int a, int b){
        Node<T> aux = this.read(a), axi = this.read(b), axo = this.first;
        T A = aux.data;
        T B = axi.data;
        while(axo!=null){
            if(axo.equals(aux)){
                aux.data = B;
            }
            if(axo.equals(axi)){
                axi.data = A;
            }
            axo = axo.next;
        }
    }

    public boolean isEmpty(){
        if(this.count == 0 && this.first == null && this.last == null){
            return true;
        }
        return false;
    }

    public void makeEmpty(){
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    public T firstElement(){
        return this.first.data;
    }

    public T lastElement(){
        return this.last.data;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> aux = this.first;

        for(int i = 0; i<count; i++){
            sb.append(aux.data);
            sb.append(", ");
            aux = aux.next;
        }

        if(isEmpty()){
            sb.append("No hay nada  ");
        }

        String toReturn = sb.substring(0, sb.length() - 2);
        return toReturn + "]";
    }
}

class Stack<T> extends DoubleLinkedList{

    public Stack(){                 //inicializar la pila  vacía
        super.makeEmpty();
    }

    public boolean isStackEmpty(){  //Verificar si está vacío 
        return super.isEmpty();
    }

    public void makeStackEmpty(){   //Hacer la pila vacía
        super.makeEmpty();
    }

    public void push(T value){      //ingresar datos
        super.insertEnd(value);
    }

    public void pop(){              //Eliminar datos
        super.deleteEnd();
    }

    public T top(){                 //Ver el ultimo elemento de la Pila
        return (T) super.lastElement();
    }

    public int lengthStack(){       //Conocer la longjitud de la Pila
        return super.count;
    }

    public String show(){           //Mostrar los elementos de la Pila
        return super.toString();
    }
}

class Queue<T> extends DoubleLinkedList{
    public Queue(){                 //Inicializar la Cola vacía
        super.makeEmpty();
    }

    public boolean isQueueEmpty(){  //Verificar que la Cola está vacía
        return super.isEmpty();
    }

    public void enqueue(T value){   //Ingresar datos
        super.insertBegin(value);
    }

    public void dequeue(){          //Eliminar datos
        super.deleteEnd();
    }

    public T peek(){                //Ver el ultimo elemento de la Cola
        return (T) super.lastElement();
    }

    public int lengthQueue(){       //Ver la longitud de la Cola
        return super.count;
    }

    public String show(){           //Mostrar la Cola
        return super.toString();
    }
}

public class DobleEnlazada{
    public static void main(String[] args){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("************************************Lista Doble Enlazada************************************");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        DoubleLinkedList<Integer> myList = new DoubleLinkedList<>();
        System.out.println(myList.toString());
        myList.insertBegin(6);
        myList.insertBegin(4);
        myList.insertBegin(2);
        myList.insertEnd(8);
        myList.insertEnd(3);
        myList.insertEnd(1);/*
        System.out.println(myList.toString());
        myList.insert(7,4);
        System.out.println(myList.toString());
        myList.change(1,5);
        System.out.println(myList.toString());
        myList.deleteBegin();
        System.out.println(myList.toString());
        myList.deleteEnd();
        System.out.println(myList.toString());
        myList.delete(3);
        System.out.println(myList.toString());
        myList.delete(3);*/
        System.out.println(myList.toString());
        System.out.println(myList.position(8));/*
        myList.change(0,2);
        System.out.println(myList.toString());

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("******************************************* Pila *******************************************");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();

        Stack<Integer> myStack = new Stack<>();
        myStack.push(5);
        myStack.push(6);
        myStack.push(1);
        myStack.push(3);
        myStack.pop();
        System.out.println(myStack.top());
        System.out.println(myStack.show());
        System.out.println(myStack.lengthStack());

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("********************************************* Cola *****************************************");
        System.out.println("--------------------------------------------------------------------------------------------");
        
        Queue<Integer> myQueue = new Queue<>();
        myQueue.enqueue(9);
        myQueue.enqueue(8);
        myQueue.enqueue(7);
        myQueue.enqueue(6);
        myQueue.enqueue(5);
        System.out.println(myQueue.show());
        myQueue.dequeue();
        myQueue.dequeue();
        System.out.println(myQueue.show());
        myQueue.enqueue(4);
        System.out.println(myQueue.show());     
        System.out.println(myQueue.peek());
        System.out.println(myQueue.lengthQueue());*/
    }
}