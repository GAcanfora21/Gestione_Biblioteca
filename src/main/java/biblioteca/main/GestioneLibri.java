/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.ObservableList;

/**
 * @file GestioneLibri.java
 * @brief La classe si occupa di aggiungere, eliminare e cercare libri. 
 * 
 * @invariant libro != null
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
public class GestioneLibri implements Gestore<Libri>{
    
    private ObservableList<Libro> libri;

    public GestioneLibri() {
    }
    
    
    
    public ObservableList<Libro> getLibri(){
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
