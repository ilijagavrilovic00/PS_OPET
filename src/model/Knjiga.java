/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ilija
 */
public class Knjiga {
    private int id;
    private String naziv;
    private Autor autor;
    private String ISBN;
    private int godinaIzdavanja;
    private Zanr zanr;

    public Knjiga() {
    }

    public Knjiga(String naziv, Autor autor, String ISBN, int godinaIzdavanja, Zanr zanr) {
        this.naziv = naziv;
        this.autor = autor;
        this.ISBN = ISBN;
        this.godinaIzdavanja = godinaIzdavanja;
        this.zanr = zanr;
    }

    public Knjiga(int id, String naziv, Autor autor, String ISBN, int godinaIzdavanja, Zanr zanr) {
        this.id = id;
        this.naziv = naziv;
        this.autor = autor;
        this.ISBN = ISBN;
        this.godinaIzdavanja = godinaIzdavanja;
        this.zanr = zanr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getGodinaIzdavanja() {
        return godinaIzdavanja;
    }

    public void setGodinaIzdavanja(int godinaIzdavanja) {
        this.godinaIzdavanja = godinaIzdavanja;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    
    @Override
    public String toString() {
        return "Knjiga{" + "naziv=" + naziv + ", autor=" + autor + ", ISBN=" + ISBN + ", godinaIzdavanja=" + godinaIzdavanja + '}';
    }
    
    
    
    
}
