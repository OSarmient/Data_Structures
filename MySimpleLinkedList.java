/*import java.util.LinkedList;

class Nodo<TipoDeDato>{
    TipoDeDato dato;
    Nodo<TipoDeDato> siguiente;
    Nodo<TipoDeDato> anterior;

    public Nodo(TipoDeDato data){
        this.dato = data;
        this.siguiente = null;
        this.anterior = null;
    }

    public TipoDeDato getDato(){
        return dato;
    }
}

public class MySimpleLinkedList<T>{
    Nodo<T> first;
    Nodo<T> last;
    Integer count;

    public MySimpleLinkedList(){  //Crea por primera vez una linked list vacia
        this.makeEmpty();
    }

    public void MySimpleLinkedList(T[] array){ //Crea una linked list con los parametros de un arreglo en orden
        for(int i = 0; i< array.length; i++){
            insertBigin(array[i]);
        }
    }

    void insertBigin(T toInsert){ //O(1) Incerta en el primer  puesto de la lista
        Nodo<T> newNode = new Nodo<>(toInsert);
        if(isEmpty()){
            this.last = newNode;
            this.first = newNode;
            this.count++;
            return;
        }
        this.first.anterior = newNode;
        newNode.siguiente = this.first;
        this.first = newNode;
        count++;
    }

    void insertEnd(T toInsert){
        Nodo<T> newNode = new Nodo<>(toInsert);
        if(isEmpty()){
            this.last = newNode;
            this.first = newNode;
            this.count++;
            return;
        }
        this.last.siguiente = newNode;
        newNode.anterior = this.last;
        this.last = newNode;
        count++;
    }

    void deleteBigin(){  //O(1)      Borra el primer dato de la lista
        if(this.first ==null){
            System.err.println("No puedo eleiminar de una lista vacía");
            return;
        }
        this.first = this.first.siguiente;
        this.first.anterior = null;
        this.count--;
    }

    void deleteEnd(){
        if(this.last==null){
            System.err.println("No puedo eliminar de una lista vacía");
            return;
        }
        /*if(this.last.anterior == null){
             this.last = null;
             this.count--;
             return;
        }*/
        this.last = this.last.anterior;
        //this.last.siguiente = null;
        this.count--;
    }

    String find(T data){  //O(n)    Encuetra la posición de un dato de la lista sin importar su repeticion
        if(count == 0){
            System.err.println("No puedo buscar de una lista vacía");
            return null;
        }
        Nodo<T> aux = this.first;
        Integer index = 0;

        StringBuilder nsb = new StringBuilder();
        nsb.append("[");

        while(aux != null){
            if(data.equals(aux.dato)){ //[4,5,6,4]
                nsb.append(index);
                nsb.append(", ");
            }
            index++; 
            aux = aux.siguiente;
            
            
        }       //(8n) => O(n+n) => O(n)
        String retorno = nsb.substring(0, nsb.length()-2);
        return retorno + "]";
    }

    void makeEmpty(){               //Vuelve los indices de la lista vacias
        this.count=0;
        this.first=null;
        this.last=null;
    }

    public boolean isEmpty(){
        if(this.count == 0){
            return true;
        }
        return false;
    }

    private boolean checkarIndice(int k){
        return k<0||k>this.count;
    }

    Nodo<T> read(int k){                  //Muestra el dato en una posicion [0, n-1]
        if(k<0||k>this.count){
            System.out.print("No es posinle realizar la busqueda");
            return null;
        }
        Nodo<T> aux = this.first;
        for(int i = 0; i<k; i++){
            aux = aux.siguiente;
        }
        return aux;
    }

    void insert(int k, T data){     //O(n) Incertar en cualquier indice de la listaa
        if(this.checkarIndice(k)){
            System.out.println("No es posible hacer la insercion en ese indice");
            return;
        }
        if(k==0){
            this.insertBigin(data);
            return;
        }
        Nodo<T> nuevoNodo = new Nodo<>(data), aux = this.read(k-1);
        nuevoNodo.siguiente = aux.siguiente;
        aux.siguiente = nuevoNodo;
        this.count++;
    }

    void delete(int k){             //Borra un indeice de la linked list en cualquier poocision
        if(this.checkarIndice(k)){
            System.err.println("No es posible borrar de este indice");
            return;
        }
        Nodo<T> aux = this.read(k-1), axi=this.read(k);
        aux.siguiente= axi.siguiente;
        this.count--;
    }

    @Override
    public String toString(){       //Muestra la lista completa
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> aux = this.first;

        while(aux != null){
            sb.append(aux.dato);
            sb.append(", ");
            aux = aux.siguiente;
        }
        if(aux == null){
            sb.append("No hay na");
        }
        String toReturn = sb.substring(0, sb.length() - 2);
        return toReturn + "]";
    }

    T lastValue(){
        Nodo<T> aux = this.last;
        return aux.dato;
    }

    T fisrtValue(){
        Nodo<T> aux = this.first;
        return aux.dato;
    }
}


/*class SimpleLikedList {
    public static void main(String[] args){
        MySimpleLinkedList<String> myList = new MySimpleLinkedList<>();
        String enteros[] = {"Hola", "mundo", "te", "quiero", "mundo"};
        myList.MySimpleLinkedList(enteros);
        System.out.println(myList.toString());
        myList.insert(0, "Yo suelo recordar:");
        System.out.println(myList.toString());
        System.out.println(myList.find("mundo"));
        myList.lastValue();
    }
}*/
