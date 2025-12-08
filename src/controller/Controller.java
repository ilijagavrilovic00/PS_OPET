/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Autor;
import model.Knjiga;
import model.User;
import model.Zanr;

/**
 *
 * @author ilija
 */
public class Controller {
    private DBBroker dbb;
    private List<Knjiga> listaKnjiga;
    private List<Autor> listaAutora;
    private List<User> listaUsera;
    
    
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
        /*Autor a1 = new Autor("Ivo", "Andric", 1892, "Biografija Ivo");
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
        listaAutora.add(a3);*/
        
        
        dbb = new DBBroker();
        
        
        listaUsera = new ArrayList<>();
        User u1 = new User(1, "vanja", "vanja");
        User u2 = new User(2, "vanja2", "vanja2");
        User u3 = new User(3, "vanja3", "vanja3");

        listaUsera.add(u1);
        listaUsera.add(u2);
        listaUsera.add(u3);
        
        
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

    public void obrisiKnjigu(int id) {
        dbb.obrisiKnjigu(id);
        //listaKnjiga.remove(selektovaniRed);
    }

    public void dodajKnjigu(Knjiga knjiga) {
        //listaKnjiga.add(knjiga);
        dbb.dodajKnjigu(knjiga);
    }

    public List<Knjiga> ucitajListuKnjiga() {
        this.listaKnjiga = dbb.ucitajListuKnjigaIzBaze();
       return this.listaKnjiga;
    }

    public List<Autor> getListaAutoraIzBaze() {
        return dbb.ucitajListuAutoraIzBaze();
    }

    public List<User> getListaUsera() {
        return listaUsera;
    }

    public void setListaUsera(List<User> listaUsera) {
        this.listaUsera = listaUsera;
    }

    public boolean login1(String username, String password) {
        for (User u: listaUsera){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean login2(String username, String password) {
        return dbb.login(username, password);
    }

    public List<Knjiga> filtriraj(String autor, String naslov) {
        List<Knjiga> rezultat = new ArrayList<>();
        
        if(autor != null){
            for(Knjiga knjiga: listaKnjiga){
                String autorKnjige = knjiga.getAutor().getIme()+" "+knjiga.getAutor().getPrezime();
                if(autorKnjige.contains(autor)){
                    rezultat.add(knjiga);
                }
            }
        }
          if(autor==null && naslov!=null){
          for(Knjiga k: listaKnjiga){
              if(k.getNaziv().contains(naslov)){
                  rezultat.add(k);
              }
         }
        }  
        if(autor!=null && naslov!=null){
          for(Knjiga k: listaKnjiga){
              String autorKnjige = k.getAutor().getIme()+" "+k.getAutor().getPrezime();
              if(autorKnjige.contains(autor) && k.getNaziv().contains(naslov)){
                  rezultat.add(k);
                }
            }
        }
        
      List<Knjiga> rezultat2 = new ArrayList<>();
        rezultat2 = listaKnjiga.stream().filter(k->(naslov!=null && k.getNaziv().contains(naslov))
        && (autor!=null && (k.getAutor().getIme()+" "+k.getAutor().getPrezime()).contains(autor))).collect(Collectors.toList());
        
        return rezultat2;
    }

    public List<Knjiga> filtriraj2(String autor, String naslov) {
        return dbb.filtriraj2(autor,naslov);
    }
    
    
    
}
