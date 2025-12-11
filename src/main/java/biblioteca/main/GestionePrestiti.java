/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import java.io.IOException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @file GestionePrestiti.java
 * @brief La classe si occupa di registrare nuovi prestiti e restituzioni. 
 * 
 * @invariant listaPrestiti != null
 * 
 * @see Prestito.java
 * @see IF-11
 * @see IF-13
 * @see BF-3
 * @see FC-1
 * @see FC-2
 * @author Enrico
 * @date December 06, 2025
 * @version 1.0
 */
public class GestionePrestiti {
    
    private ObservableList<Prestito> listaPrestiti;

    public GestionePrestiti(){
        this.listaPrestiti = FXCollections.observableArrayList();
    }
    
    
    
    public ObservableList<Prestito> getPrestiti(){
        return this.listaPrestiti;
    }
    
    /**
     * @brief Registra un nuovo prestito.
     * 
     * @param[in] prestito Prestito da registrare
     * @pre prestito.getLibro().getNumCopie() > 0 
     * @pre prestito.getUtente().getPrestitiAttivi() < 3
     * @post Il prestito viene registrato nell'elenco.
     * @post libro.numCopie viene decrementato di 1
     * @post utente.prestitiAttivi viene incrementato di 1
     * 
     * @see IF-11
     * @see FC-1
     * @see FC-2
     */
    public void registraPrestito(Prestito prestito){
        
        if(prestito.getLibro().getNumCopie() > 0 && prestito.getUtente().getPrestitiAttivi() < 3){
            listaPrestiti.add(prestito);
            prestito.getLibro().rimuoviCopie();
            prestito.getUtente().incrementaPrestiti();
        }
        else{
            return;
        }
    }
    
    /**
     * @brief Registra la restituzione di un prestito.
     * 
     * @param[inout] prestito Prestito da registrare come restituito
     * @pre prestito != null
     * @pre prestito.getAttivo() == true
     * @post prestito.getAttivo() == false
     * @post libro.numCopie viene incrementato di 1
     * @post utente.prestitiAttivi viene decrementato di 1
     * 
     * @see IF-13
     * @see registraPrestito()
     */
    public void registraRestituzione(Prestito prestito){
        
        if(prestito != null){
            prestito.setAttivo(false);
            prestito.getLibro().aggiungiCopie();
            prestito.getUtente().decrementaPrestiti();
        }
        else{
            throw new IllegalArgumentException("Prestito null!");
        }
            
    }
}
