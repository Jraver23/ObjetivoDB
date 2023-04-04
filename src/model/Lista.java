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
        ArrayList<T> arrList = new ArrayList<>(lista);
        return arrList;
    }

    @Override
    public String toString() {
        String result = "{";
        for (Object objeto:this.lista) {
            if (objeto.equals(this.lista.get(this.lista.size()-1))) {
                result += objeto.toString();
            }
            else {
                result += objeto.toString() + ", ";
            }
        }
        result += "}";
        return result;
    }
}

