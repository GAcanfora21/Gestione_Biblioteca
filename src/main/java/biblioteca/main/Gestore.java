/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.ObservableList;

/**
 * @file Gestore.java
 * @brief questa interfaccia definisce
 * 
 * @author Giuseppe
 * @date December 06, 2025
 * @versione 1.0
 */
public interface Gestore<T> {
    
    /**
     * @brief metodo che permette di aggiungere un elemento
     * @param[in] elem elemento da aggiungere 
     */
    public void aggiungi(T elem);
    
    /**
     * @brief metodo che permette di rimuovere un elemento
     * @param[in] elem elemento da rimuovere 
     */
    public void elimina(T elem);
    
    /**
     * @brief metodo che permette di cercare un elemento
     * @param[in] elem elemento da cercare
     * @return T l'oggetto trovato
     */
    public ObservableList<T> cerca(String elem);
    
}
