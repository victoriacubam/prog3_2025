package prog3_2025.tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T>{

    private Node<T> first;
    private Node<T> last;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Ejercicio 1
     * Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría(
     * void insertFront(T), T extractFront(), boolean isEmpty(), int size(),
     * String toString). Agregar también el metodo: T get(index)
     */

    //Inserta al principio
    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        if (this.isEmpty()){
            this.first = tmp;
            this.last= tmp;
        } else {
            tmp.setNext(this.first);
            this.first = tmp;
        }
        this.size++;
    }

    //Devuelve la info y al nodo lo saca
    public T extractFront() {
        if (!this.isEmpty()){
            Node<T> tmp = this.first;
            T info = tmp.getInfo();
            this.first = tmp.getNext();
            this.size--;
            return info;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    public T get(int index) {
        if (!this.isEmpty() && index < this.size){
            int contador = 0;
            Node<T> nodo = this.first;
            while (contador<index){
                nodo = nodo.getNext();
                contador++;
            }
            return nodo.getInfo();
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    /**
     * Ejercicio 3
     * A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
     * int indexOf(T)  , que reciba un elemento y retorne el índice donde está almacenado ese
     * elemento, o -1 si el elemento no existe en la lista.
     */
    public int indexOf(T info){
        if (!this.isEmpty()){
            int index = 0;
            Node<T> tmp = this.first;
            while (tmp!=null && !tmp.getInfo().equals(info)){
                tmp = tmp.getNext();
                index++;
            }
            if (tmp!=null && tmp.getInfo().equals(info)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String lista = "";
        if (!this.isEmpty()){
            Node<T> tmp = this.first;
            for (int i= 0; i<this.size; i++){
                lista += tmp.toString() + " ";
                tmp = tmp.getNext();
            }
        }
        return lista;
    }

    /* Ejercicio 4
     * A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
     * iterator-iterable, para que la lista sea iterable.
     */

    /**
     * Va a crear un iterador, pasarle el primer nodo de la lista,
     * la clase MyIterator lo va a guardar (en su atributo cursor)
     * y cuando se quiera recorrer va a preguntar si hay un siguiente.
     * Si la lista no tiene un primer nodo, se pasaria un null por lo tanto
     * al preguntar si hay un siguiente daria null y no se recorreria más
     */
    @Override
    public Iterator<T> iterator() { //Hay que definir el iterador a devolver
        return new MyIterator<>(this.first);
    }

    /*
     * Ejercicio 5
     * Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes
     *
     * a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
     */

    public MySimpleLinkedList<T> unionListaDesordenada(MySimpleLinkedList<T> listaDesordenada){
        MySimpleLinkedList<T> listaResultante = new MySimpleLinkedList<>();
        for (T i: this){
            for (T x: listaDesordenada){
                if (i.equals(x)){
                    listaResultante.insertarOrdenado(i);
                }
            }
        }
        return listaResultante;
    }

//    public void insertarOrdenado(T info) {
//        if (this.isEmpty()) {
//            this.first = new Node<>(info, null);
//            this.last = this.first;
//        } else {
//            for (T i : this) {
//                if (i.compareTo(info)<0) { // i es menor
//
//                }
//                else if (i.compareTo(info)>0) { // i es mayor
//
//                }
//                else { // son iguales
//
//                }
//            }
//            this.size++;
//        }
//    }
        /**
         * b)
         * Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
         */
        public MySimpleLinkedList<T> unionListaOrdenada (MySimpleLinkedList < T > listaOrdenada) {
            MySimpleLinkedList<T> listaResultante = new MySimpleLinkedList<>();
            for (T i : this) {
                for (T x : listaOrdenada) {
                    if (i.equals(x)) {
                        listaResultante.insertLast(i);
                    }
                }
            }
            return listaResultante;
        }

        //Inserta al final
        public void insertLast (T info) {
            if (this.isEmpty()) {
                this.first = new Node<>(info, null);
                this.last = this.first;
            } else {
                Node<T> tmp = new Node<T>(info, null);
                this.last.setNext(tmp);
                this.last = tmp;
            }
            this.size++;
        }
}