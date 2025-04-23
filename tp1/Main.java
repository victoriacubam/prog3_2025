package prog3_2025.tp1;

import java.sql.SQLOutput;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> l1 = new MySimpleLinkedList<>();
        l1.insertFront(4);
        l1.insertLast(10);
        l1.insertFront(3);
        l1.insertFront(2);
        l1.insertFront(1);

        MySimpleLinkedList<Integer> l2 = new MySimpleLinkedList<>();
        l2.insertLast(3);
        l2.insertLast(5);
        l2.insertLast(6);
        l2.insertLast(9);
        l2.insertLast(12);

        MySimpleLinkedList<Integer> l3 = new MySimpleLinkedList<>();
        l3.insertLast(5);
        l3.insertLast(7);
        l3.insertLast(9);
        l3.insertLast(12);
        l3.insertLast(15);
        //System.out.println("Lista v1: " + l1);
        //System.out.println("Lista[3]: " + l1.get(4));
        //System.out.println("Extraer el primer nodo v1: " + l1.extractFront());
        //System.out.println("Lista v2: " + l1);
        //System.out.println("Extraer el primer v2: " + l1.extractFront());
        //System.out.println("Lista v3: " + l1);

        //System.out.println(l1.indexOf(8));

        //Se declara un iterator del mismo tipo de la lista y se lo pedimos a la lista (que ya lo tiene implementado)
//        Iterator<Integer> iter = l1.iterator();
//        while (iter.hasNext()){
//            Integer i = iter.next();
//            System.out.println(i);
//        }

        //Tener el iterator implementado tambien permite recorrer de la siguiente manera:
        //Internamente, este for lo que hace es el while de arriba
//        for (int i: l1){ //Esto es posible porque la lista implementa iterable
//            System.out.println(i);
//        }
        System.out.println("Lista A");
        for (int i: l2){
           System.out.println(i);
        }
        System.out.println("Lista B");
        for (int i: l3){
            System.out.println(i);
        }

        MySimpleLinkedList<Integer> listaOrdenada = l2.unionListaOrdenada(l3);
        System.out.println("Lista Ordenada resultante de A y B");
        for (int i: listaOrdenada){
            System.out.println(i);
        }
    }
}
