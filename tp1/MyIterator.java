package prog3_2025.tp1;

import java.util.Iterator;

public class MyIterator <T> implements Iterator<T> {
    private Node<T> cursor;

    public MyIterator(Node<T> cursor) {
        this.cursor = cursor;
    }

    //Para poder iterar sobre la lista, lo que se va a hacer es preguntar continuamente si
    //hay un siguiente, y si devuelve true, entonces pedir el siguiente con el método next()
    @Override
    public boolean hasNext() {
        return this.cursor!=null;
    }

    //Devuelvo el valor del cursor actual y paso al siguiente
    @Override
    public T next() {
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }
}
