package biblioteca.main;

import java.time.LocalDate;

/**
 * @file Prestito.java
 * @brief Definisce attributi e metodi della classe Prestito.
 * 
 * 
 * @author Enrico
 * @date December 02, 2025
 * @version 1.0
 */
public class Prestito {
    
    private Utente utente;
    private Libro libro;
    private LocalDate dataRestituzione;
    private boolean attivo;
    
    /**
     * @brief Costruttore di Prestito.
     * @brief Costruttore completo di Prestito
     * 
     * @param[in] utente L'utente che prende in prestito
     * @param[in] libro Il libro prestato
     * @param[in] dataRestituzione Data prevista per la restituzione
     * 
     * @pre libro != null
     * @pre utente != null
     * @pre dataRestituzione != null
     * @post attivo == true
     */
    public Prestito(Utente utente, Libro libro, LocalDate dataRestituzione){
    
        this.utente = utente;
        this.libro = libro;
        this.dataRestituzione = dataRestituzione;
        this.attivo = true;
    }
    
    public Utente getUtente(){
        return this.utente;
    }
    
    public Libro getLibro(){
        return this.libro;
    }
    
    public LocalDate getDataRestituzione(){
        return this.dataRestituzione;
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
        return this.attivo;
    }
    
    
    /**  
     * @brief Imposta lo stato del prestito.
     * 
     * Il metodo consente di impostare lo stato di un prestito come attivo/non attivo.
     * @param[in] stato Stato del prestito
     * 
     * @see getAttivo()
     */
    public void setAttivo(boolean stato){
        this.attivo = stato;
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
        return LocalDate.now().isAfter(this.dataRestituzione);
    }
    
    
    @Override
    public String toString(){
        return "Prestito: " + getUtente() + " | " + getLibro() + " | " + getDataRestituzione() + "\n";
    }
}
