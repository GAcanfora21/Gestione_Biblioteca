/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import java.time.LocalDate;
import javafx.collections.ObservableList;

/**
 * @file GestionePrestiti.java
 * @brief La classe si occupa di registrare nuovi prestiti e restituzioni. 
 * 
 * @invariant prestito != null
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
    
    private ObservableList<Prestito> prestiti;

    public GestionePrestiti() {
    }
    
    
    
    public ObservableList<Prestito> getPrestiti(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief Registra un nuovo prestito.
     * 
     * @param[in] prestito Prestito da registrare
     * @pre prestito.getLibro().getNumCopie() > 0 
     * @pre prestito.getUtente().getPrestitiAttivi() < 3
     * @post Il prestito viene registrato nell'elenco.
     * @post libro.numCopie viene decrementato di 1 (GestioneLibri)
     * @post utente.prestitiAttivi viene incrementato di 1 (GestionePrestiti)
     * 
     * @see IF-11
     * @see FC-1
     * @see FC-2
     */
    public void registraPrestito(Prestito prestito){
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
