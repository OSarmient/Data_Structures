/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Test {
    
    public static void main(String args[]){
        /*MySimpleLinkedList<String> myList = new MySimpleLinkedList<>();
        String enteros[] = {"Hola", "mundo", "te", "quiero", "mundo"};
        myList.MySimpleLinkedList(enteros);
        System.out.println(myList.toString());
        myList.insert(0, "Yo suelo recordar:");
        System.out.println(myList.toString());
        System.out.println(myList.find("mundo"));
        System.out.println(myList.lastValue());
        myList.deleteEnd();
        System.out.println(myList.toString());
        */
        Cola <String> Bb = new Cola<>();
        Bb.enqueue("1");
        //Bb.enqueue("2");
        //Bb.enqueue("3");
        System.out.println(Bb.toString());
        System.out.println(Bb.dequeue());
        System.out.println(Bb.count);
        System.out.println(Bb.toString());
    }
    
}
