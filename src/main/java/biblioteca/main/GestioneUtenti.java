/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @file GestioneUtenti.java
 * @brief La classe si occupa di aggiungere, eliminare e cercare utenti. 
 * 
 * @invariant utente != null
 * 
 * 
 * @see Utente.java
 * @see IF-6
 * @see IF-8
 * @see IF-10
 * @see BF-2
 * @see FC4
 * @see FC5
 * @author Enrico
 * @date December 06, 2025
 * @version 1.0
 */
public class GestioneUtenti implements Gestore<Utente>{
    
    private ObservableList<Utente> listaUtenti;

    public GestioneUtenti() {
        this.listaUtenti = FXCollections.observableArrayList();
    }
    
    
    
    public ObservableList<Utente> getUtenti(){
        return this.listaUtenti;
    }
    
    /**
     * @brief Aggiunge un utente nell'elenco.
     *  
     * @param[in] utente Utente da aggiungere.
     * 
     * @pre utente != null
     * @post L'utente è stato aggiunto all'elenco.
     * 
     * @see IF-6
     * @see FC4
     * @see FC5
     */
    public void aggiungi(Utente utente){
        if(utente == null) throw new IllegalArgumentException("Utente passato non può avere valore null");
        listaUtenti.add(utente);
    }
    

    /**
     * @brief Elimina un utente dell'elenco.
     * 
     * @param[in] utente Utente da rimuovere
     * @pre utente != null
     * @pre L'utente da eliminare non deve avere prestiti attivi.
     * @post L'utente è stato rimosso dall'elenco.
     * 
     * @see IF-8
     */
    public void elimina(Utente utente){
        if(utente == null) throw new IllegalArgumentException("Non posso eliminare un utente con valore null");
        listaUtenti.remove(utente);
    }
    
    
    /**
     * @brief Cerca un utente nell'elenco.
     * 
     * @param[in] str La stringa (cognome/matricola) contenuta nel libro desiderato.
     * @pre str != null
     * 
     * 
     * @return Una lista di utenti che contengono la stringa in almeno uno dei loro campi.
     * 
     * @see IF-10
     * @see ValidaDatiUtente.java
     */
    public ObservableList<Utente> cerca(String str){
        if(str == null || str.isEmpty()) return FXCollections.observableArrayList();
        
        //Creo una lista temporanea vuota dove andrò a inserire i vari risultati ottenuti
        ObservableList<Utente> result = FXCollections.observableArrayList();
        
        //Un for each di 'listLibri' necessaria per scorrere tutti gli elementi della lista e verificarne le uguaglianze con la stringa passata
        for(Utente u : listaUtenti){
            if((u.getCognome()!= null && u.getCognome().equalsIgnoreCase(str)) ||
               (u.getMatricola() != null && u.getMatricola().equalsIgnoreCase(str))){
            
                result.add(u);
            }
        }
        
        return result;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("GestioneLibri contiene ").append(listaUtenti.size()).append(" libri:\n");
        for(Utente u : listaUtenti){
            sb.append(u.toString()).append("\n");
        }
        return sb.toString();
    }
}
