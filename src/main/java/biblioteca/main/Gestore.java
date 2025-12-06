/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.ObservableList;

/**
 * @file Gestore.java
 * @brief L'interfaccia contiene metodi di manipolazione e ricerca dati.
 * 
 * @author Giuseppe
 * @date December 06, 2025
 * @versione 1.0
 */
public interface Gestore<T> {
    
    /**
     * @brief Aggiunge un elemento a una collezione.
     * @param[in] elem Elemento da aggiungere 
     */
    public void aggiungi(T elem);
    
    /**
     * @brief Rimuove un elemento da una collezione.
     * @param[in] elem Elemento da rimuovere 
     */
    public void elimina(T elem);
    
    /**
     * @brief Cerca un elemento in una collezione.
     * @param[in] elem Elemento da cercare
     * @return T l'oggetto trovato
     */
    public ObservableList<T> cerca(String elem);
    
}
