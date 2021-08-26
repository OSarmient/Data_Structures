import java.io.*;
import java.util.Scanner;

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
        Node<T> aux = this.first;

        for(int i = 0; i<count; i++){
            sb.append(aux.data);
            sb.append(" ");
            aux = aux.next;
        }

        if(isEmpty()){
            sb.append("No hay nada ");
        }

        String toReturn = sb.substring(0, sb.length() - 1);
        return toReturn;
    }

    public void duplicate(int a, int b){
        Node<T> aux = this.read(a), axi = this.read(b), axo = this.first;
        T A = aux.data;
        while(axo!= null){
            if(axo.equals(axi)){
                axi.data = A;
            }
            axo = axo.next;
        }
    }

    public void sort(){
        Node<T> aux = this.first;
        int c = 0;
        while(aux.next != null){
            if(((Integer) aux.next.data).compareTo((Integer) aux.data) <0){
                T value = aux.next.data;
                duplicate(c, c+1);
                System.out.print(toString() + " \n");
                while(aux.previous != null){
                    if(((Integer) aux.previous.data).compareTo((Integer)value) < 0){
                        Integer index = position((Integer)aux.data);
                        delete(index);
                        insert(value, index);
                        System.out.print(toString());
                        
                    }else{
                        duplicate(c-1,c);
                        System.out.print(toString());
                        if(c !=0){
                            System.out.print(" \n");
                        }
                    }   

                    if(this.first.data == this.first.next.data){
                        deleteBegin();
                        insertBegin(value);
                        System.out.print(toString());
                    }
                    
                    c--;
                    aux = aux.previous;
                }
            }
            c++;
            aux= aux.next;
        }
    }
}

public class TallerOrdenamiento{
    public static void main(String[] args)throws IOException{
        DoubleLinkedList<Integer> daList = new DoubleLinkedList<>();
        Scanner br = new Scanner(System.in);
        int size;
        size = br.nextInt();
        for(int i = 0; i < size; i++){
            int value = br.nextInt();
            daList.insertEnd(value);
        }
        daList.sort();
        br.close();
    }
}