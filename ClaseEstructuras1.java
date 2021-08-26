public class ClaseEstructuras1{
    public static void main(String[] args){
        Node<String> Nodo1 = new Node<>("A0");
        Node<String> Nodo2 = new Node<>("A1");
        Node<String> Nodo3 = new Node<>("A2");
        Node<String> Nodo4 = new Node<>("A3");
        Node<String> Nodo5 = new Node<>("A4");
        Nodo1.next = Nodo2;
        Nodo2.next = Nodo3;
        Nodo3.next = Nodo4;
        Nodo4.next = Nodo5;
        Node<String> NodoX = new Node<>("x");
        Nodo2.next = NodoX;
        NodoX.next = Nodo3;


        double[] arr = {0,1,2,3,4,5,6,7,8,9};
        double[] arr2 = new double[arr.length+1];
        for(int i = 0; i<arr.length; i++){
            arr2[i] = arr[i];
        }
        arr2[10] = 10;
        for(int i = 0; i<arr2.length; i++){
            System.out.println(arr2[i]);
        }
    }
}

/*class Node <T> {
    T data;
    Node<T> next;
    public Node(T data){
        this.data = data;
        this.next = null;
    }
}*/