/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.ObservableList;

/**
 * @file GestioneBiblioteca.java
 * @brief Gestisce libri, utenti e prestiti.
 * 
 * Questa classe si occupa di aggiungere, modificare e rimuovere libri, utenti e prestiti.
 * 
 * @invariant libri != null
 * @invariant utenti != null
 * @invariant prestiti != null
 * 
 * @see Libro
 * @see Prestito
 * @see Utente
 * @see BF-1
 * @see BF-2
 * @see BF-3
 * 
 * @author Giuseppe
 * @date December 03, 2025
 * @version 1.0
 */
public class GestioneBiblioteca {
    
    private ObservableList<Libro> libri;
    private ObservableList<Utente> utenti;
    private ObservableList<Prestito> prestiti;
    
    /**
     * @brief Costruttore di GestioneBiblioteca.
     * 
     * @post libri != null && libri.isEmpty()
     * @post utenti != null && utenti.isEmpty()
     * @post prestiti != null && prestiti.isEmpty()
     */
    public GestioneBiblioteca(){
        
    }
    
    
    /**
     * @brief Restituisce una lista dei libri
     * 
     * @return ObservableList dei libri
     */
    public ObservableList<Libro> getLibri(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    /**
     * @brief restituisce una lista degli utenti
     * 
     * @return ObservableList degli utenti
     */
    public ObservableList<Utente> getUtenti(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    /**
     * @brief restituisce una lista dei prestiti
     * 
     * @return ObservableList dei prestiti
     */
    public ObservableList<Prestito> getPrestito(){
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
    public void aggiungiLibro(Libro libro){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    /**
     * @brief Modifica un libro dell'elenco.
     *  
     * @param[in] vecchioLibro Libro da modificare
     * @param[inout] nuovoLibro Libro con dati aggiornati
     * 
     * @pre nuovoLibro != null
     * @pre vecchioLibro != null
     * @post vecchioLibro verrà sostituito con i dati aggiornati di nuovoLibro.
     * 
     * @return 'true' modificato con successo, 'false' altrimenti.
     * 
     * @see IF-2
     * @see VerificaDatiLibro.java
     */
    public boolean modificaLibro(Libro vecchioLibro, Libro nuovoLibro){
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
    public void eliminaLibro(Libro libro){
        throw new UnsupportedOperationException("Not supported yet.");
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
    public void aggiungiUtente(Utente utente){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief Modifica un utente dell'elenco.
     *  
     * @param[in] vecchioUtente Utente da modificare
     * @param[inout] nuovoUtente Utente con dati aggiornati
     * 
     * @pre nuovoUtente != null
     * @pre vecchioUtente != null
     * @post vecchioUtente verrà sostituito con i dati aggiornati di nuovoUtente.
     * 
     * @return 'true' se l'utente è stato modificato con successo, 'false' altrimenti.
     * 
     * @see IF-7
     * @see FC4
     * @see FC5
     */
    public boolean modificaUtente(Utente vecchioUtente, Utente nuovoUtente){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Elimina un utente dell'elenco.
     * 
     * @param[in] utente Utente da rimuovere
     * @pre utente != null
     * @post se 'return == true' allora l'utente è stato rimosso dall'elenco
     * 
     * @see IF-8
     */
    public void rimuoviUtente(Utente utente){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief Registra un nuovo prestito.
     * 
     * @param[in] prestito Prestito da registrare
     * @pre prestito != null
     * @pre prestito.getLibro().getNumCopie() > 0 
     * @pre prestito.getUtente().getPrestitiAttivi().size() < 3
     * @post se 'return == true' il prestito viene registrato nell'elenco
     * @post se 'return == true' il libro.numCopie viene decrementato di 1
     * @post se 'return == true' il prestito verrà aggiunto a utenti.prestitiAttivi
     * 
     * @return 'true' prestito aggiunto con successo, 'false' altrimenti
     * 
     * @see IF-11
     * @see FC-1
     * @see FC-2
     */
    public boolean registraPrestito(Prestito prestito){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief Registra la restituzione di un prestito.
     * 
     * @param[inout] prestito Prestito da registrare come restituito
     * @pre prestito != null
     * @pre prestito.getAttivo() == true
     * @post se 'return == true' prestito.getAttivo() == false
     * @post se 'return == true' libro.numCopie viene incrementato di 1
     * @post se 'return == true' il prestito viene tolto da utenti.prestitiAttivi
     * 
     * @see IF-13
     * @see registraPrestito()
     */
    public boolean registraRestituzione(Prestito prestito){
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
    public ObservableList<Libro> cercaLibro(String str){
        throw new UnsupportedOperationException("Not supported yet.");
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
    public ObservableList<Utente> cercaUtente(String str){
        throw new UnsupportedOperationException("Not supported yet.");
    }

}


