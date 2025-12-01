/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author ilija
 */
public class Controller {
    private List<Knjiga> listaKnjiga;
    private List<Autor> listaAutora;
    
    
    //Jedina instanca klase Controller koja ce ikada biti napravljena
    private static Controller instance;
    
    public static Controller getInstance(){
     if(instance==null){
     instance = new Controller();
        }
        return instance;
    }

    //privatni kontroler se koristi za singleton pattern
    private Controller() {
        Autor a1 = new Autor("Ivo", "Andric", 1892, "Biografija Ivo");
        Autor a2 = new Autor("Stevo", "Andric", 1992, "Biografija Stevo");
        Autor a3 = new Autor("Darko", "Andric", 1692, "Biografija Darko");
    
        Knjiga k1 = new Knjiga("Na Drini cuprija", a1, "123456789", 1945, Zanr.ROMAN);
        Knjiga k2 = new Knjiga("Basta", a2, "123456789", 1982, Zanr.NAUCNA_FANTASTIKA);
        Knjiga k3 = new Knjiga("Kurva glibava", a3, "123456789", 1990, Zanr.DETEKTIVSKI);
    
        listaKnjiga = new ArrayList<>();
        listaAutora = new ArrayList<>();
        
        listaKnjiga.add(k1);
        listaKnjiga.add(k2);
        listaKnjiga.add(k3);
        
        listaAutora.add(a1);
        listaAutora.add(a2);
        listaAutora.add(a3);
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int selektovaniRed) {
        listaKnjiga.remove(selektovaniRed);
    }

    public void dodajKnjigu(Knjiga knjiga) {
        listaKnjiga.add(knjiga);
        
    }
    
}
