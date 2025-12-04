/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.ObservableList;

/**
 * @file GestioneBiblioteca.java
 * @brief Gestisce l'intero dell'elenco libri   
 * 
 * Questa classe si occupa di aggiungere, modificare, rimuovere e cercare gli Utenti, Libri e Prestiti  
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
 * @Version 1.0
 */
public class GestioneBiblioteca {
    
    ObservableList<Libro> libri;
    ObservableList<Utente> utenti;
    ObservableList<Prestito> prestiti;
    
    /**
     * @brief costruttore di GestioneBiblioteca
     * 
     * @post libri != null && libri.isEmpty()
     * @post utenti != null && utenti.isEmpty()
     * @post prestiti != null && prestiti.isEmpty()
     */
    public GestioneBiblioteca(){
        
    }
    
    
    /**
     * @brief restituisce una lista dei libri
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
     * @brief questo metodo permette di aggiungere un libro nell'elenco
     *  
     * @param[in] libro, libro da aggiungere
     * @pre libro != null
     * @post se 'return == true' allora il libro è stato aggiunto all'elenco
     * 
     * @return 'true' libro aggiunto con successo, 'false' altrimenti (FC-3)
     * 
     * @see IF-1
     * @see FC-3
     */
    public boolean aggiungiLibro(Libro libro){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    /**
     * @brief questo metodo permette di modificare un libro nell'elenco
     *  
     * @param[in] vecchioLibro, libro da modificare
     * @param[inout] nuovoLibro, libro con dati aggiornati
     * @pre nuovoLibro != null
     * @pre vecchioLibro != null
     * @post se 'return == true' allora il vecchioLibro verrà sostituito con i dati aggiornati di nuovoLibro
     * 
     * @return 'true' modificato con successo, 'false' altrimenti
     * 
     * @see IF-1
     * @see FC-3
     */
    public boolean modificaLibro(Libro vecchioLibro, Libro nuovoLibro){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief questo metodo permette di eliminare un libro nell'elenco
     *  
     * @param[in] libro, libro da rimuovere
     * @pre libro != null
     * @post se 'return == true' allora il libro è stato rimosso dall'elenco
     * 
     * @return 'true' libro modificato con successo, 'false' altrimenti
     * 
     * @see IF-1
     * @see FC-3
     */
    public boolean eliminaLibro(Libro libro){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief questo metodo permette di aggiungere un utente all'elenco
     * 
     * @param[in] utente, utente da aggiugnere
     * @pre utente != null
     * @post se 'return == true' allora l'utente è stato aggiunto all'elenco
     * 
     * @return 'true' utente eliminato con successo, false altrimenti
     * 
     * @see IF-6
     * @see FC4
     * @see FC5
     */
    public boolean aggiungiUtente(Utente utente){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief questo metodo permette di modificare un utente all'elenco
     * 
     * @param[in] vecchioUtente, utente da modificare
     * @param[inout] nuovoUtente, utente con dati aggiornati
     * @pre vecchioUtente != null
     * @pre nuovoUtente != null
     * @post se 'return == true' allora vecchioUtente verrà aggiornato con i dati aggiornati di nuovoUtente
     * 
     * @return 'true' utente modificato con successo, false altrimenti
     * 
     * @see IF-6
     * @see FC4
     * @see FC5
     */
    public boolean modificaUtente(Utente vecchioUtente, Utente nuovoUtente){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief questo metodo permette di aggiungere un utente all'elenco
     * 
     * @param[in] utente, utente da rimuovere
     * @pre utente != null
     * @post se 'return == true' allora l'utente è stato rimosso all'elenco
     * 
     * @return 'true' utente eliminato con successo, false altrimenti
     * 
     * @see IF-6
     * @see FC4
     * @see FC5
     */
    public boolean eliminaUtente(Utente utente){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief questo metodo registra un nuovo prestito
     * 
     * @param[in] prestito, prestito da registrare
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
     * @brief questo metodo registra la restituzione di un prestito
     * 
     * @param[inout] prestito, prestito da registrare come restituito
     * @pre prestito != null
     * @pre prestito.getAttivo() == true
     * @post se 'return == true' prestito.getAttivo() == false
     * @post se 'return == true' libro.numCopie viene incrementato di 1
     * @post se 'return == true' il prestito viene tolto da utenti.prestitiAttivi
     * 
     * @return 'true' prestito restituito con successo, 'false' altrimenti
     * 
     * @see IF-13
     * @see regisraPrestito()
     */
    public boolean registraRestituzione(Prestito prestito){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief cerca un libro nell'archivio per ...
     * 
     * @param[in] 
     * @pre 
     * 
     * 
     * @return viene ritorna il valore del libro trovato tramite codice
     * 
     * @see IF-5
     * @see ValidaDatiLibro.java
     */
    public ObservableList<Libro> cercaLibro(String str){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public ObservableList<Utente> cercaUtente(String str){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    /**
    * @brief Salva l'archivio su file CSV.
    * 
    * @param[in] nomeFile Percorso del file.
    * 
    * @see IF-15
    */
    public void salvaArchivio(String nomeFile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Carica l'archivio da file CSV.
     * 
     * @param[in] nomeFile Percorso del file.
     * @return 'true' se caricato con successo, false altrimenti.
     * 
     * @see IF-16
     */
    public boolean caricaArchivio(String nomeFile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}


