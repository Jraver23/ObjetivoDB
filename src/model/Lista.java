package model;

import java.util.ArrayList;

public class Lista<T> {
    protected ArrayList<T> lista;
    public Lista() {
        lista = new ArrayList<>();
    }
    public int getSize() {
       return lista.size();
    }
    public void add(T t) {
        lista.add(t);
    }
    public void borrar(T t) {
        lista.remove(t);
    }
    public T getAt(int position) {
        return lista.get(position);
    }
    public void clear() {
        lista.clear();
    }
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(lista);
        return arrlist;
    }
}
