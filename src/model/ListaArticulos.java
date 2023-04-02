package model;

public class ListaArticulos extends Lista<Articulo>{

    ListaArticulos listaArticulos = new ListaArticulos();

    public void Añadir_articulo(Articulo a){

        listaArticulos.add(a);

    }


}