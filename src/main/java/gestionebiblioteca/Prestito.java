/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionebiblioteca;

import java.time.LocalDate;

/**
 * @file Prestito.java
 * @brief Definisce attributi e metodi della classe Prestito.
 * 
 * 
 * @author Enrico
 * @date December 02, 2025
 * @Version 1.0
 */
public class Prestito {
    
    private Utente utente;
    private Libro libro;
    private LocalDate dataRestituzione;
    private boolean attivo;
    
    
    public Utente getUtente(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Libro getLibro(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public LocalDate getDataRestituzione(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**  
     * @brief Verifica che il prestito sia attivo.
     * 
     * Il metodo consente di stabilire se il prestito sia ancora presente all'interno dell'elenco
     * dei prestiti attivi. 
     * 
     * 
     * @return 'true' se il prestito è ancora registrato nell'elenco dei prestiti, 'false' altrimenti.
     */
    public boolean getAttivo(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**  
     * @brief Verifica che il prestito sia in ritardo.
     * 
     * Il metodo consente di stabilire se il prestito risulti ancora attivo superata la data di restituzione prevista. 
     * 
     * @return 'true' se il prestito è ancora attivo superata la data di restituzione, 'false' altrimenti.
     * 
     * @see getAttivo()
     */
    public boolean isRitardo(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**  
     * @brief Imposta lo stato del prestito.
     * 
     * Il metodo consente di impostare un prestito come non attivo.
     * 
     * @pre Il prestito non è attivo.
     * @post Il prestito sarà ritenuto non attivo.
     * 
     * @see getAttivo()
     */
    public void setAttivo(){
    
    }
    
    
    @Override
    public String toString(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
