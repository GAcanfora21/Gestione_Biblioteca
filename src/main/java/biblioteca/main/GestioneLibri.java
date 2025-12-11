/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * @file GestioneLibri.java
 * @brief La classe si occupa di aggiungere, eliminare e cercare libri. 
 * 
 * @invariant listaLibri != null
 * 
 * @see Libro.java
 * @see IF-1
 * @see IF-3
 * @see IF-5
 * @see BF-1
 * @see FC-3
 * @author Enrico
 * @date December 06, 2025
 * @version 1.0
 */
public class GestioneLibri implements Gestore<Libro>{
    
    private ObservableList<Libro> listaLibri;

    public GestioneLibri() {
        this.listaLibri = FXCollections.observableArrayList();
    }
    
    
    
    public ObservableList<Libro> getLibri(){
        return this.listaLibri;
    }
    
    /**
     * @brief Aggiunge un libro nell'elenco.
     *  
     * @param[in] libro Libro da aggiungere.
     * 
     * @pre libro != null
     * @post Il libro è stato aggiunto all'elenco.
     * 
     * @see IF-1
     * @see FC-3
     */
    public void aggiungi(Libro libro){
        if(libro == null) throw new IllegalArgumentException("Libro passato non può avere valore null");
        listaLibri.add(libro);
    }
    
    
    /**
     * @brief Elimina un libro dell'elenco.
     *  
     * @param[in] libro Libro da rimuovere
     * @pre libro != null
     * @pre Il libro da eliminare non deve avere prestiti attivi.
     * @post Il libro è stato rimosso dall'elenco.
     * 
     * @see IF-3
     * @see FC-3
     */
    public void elimina(Libro libro){
        if(libro == null) throw new IllegalArgumentException("Non posso eliminare un libro con valore null");
            listaLibri.remove(libro);
    }
    
    
    /**
     * @brief Cerca un libro nell'elenco.
     * 
     * @param[in] str La stringa(titolo/autore/codice identificativo) contenuta nel libro desiderato.
     * @pre str != null
     * 
     * 
     * @return Una lista di libri che contengono la stringa in almeno uno dei loro campi.
     * 
     * @see IF-5
     * @see ValidaDatiLibro.java
     */
    public ObservableList<Libro> cerca(String str){
        
        if(str == null || str.isEmpty()) return FXCollections.observableArrayList();
        
        //Creo una lista temporanea vuota dove andrò a inserire i vari risultati ottenuti
        ObservableList<Libro> result = FXCollections.observableArrayList();
        
        //Un for each di 'listLibri' necessaria per scorrere tutti gli elementi della lista e verificarne le uguaglianze con la stringa passata
        for(Libro l : listaLibri){
            if((l.getAutori() != null && l.getAutori().equalsIgnoreCase(str)) ||
               (l.getTitolo() != null && l.getTitolo().equalsIgnoreCase(str)) ||
               (l.getCodiceIdentificativo() != null && l.getCodiceIdentificativo().equalsIgnoreCase(str))){
            
                result.add(l);
            }
        }
        
        return result;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("GestioneLibri contiene ").append(listaLibri.size()).append(" libri:\n");
        for(Libro l : listaLibri){
            sb.append(l.toString()).append("\n");
        }
        return sb.toString();
    }
}
