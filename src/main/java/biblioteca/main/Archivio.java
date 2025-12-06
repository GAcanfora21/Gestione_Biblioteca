package biblioteca.main;

import java.util.List;


/**
 * @file Archivio.java
 * @brief Questa classe gestisce il salvataggio e il caricamento dei dati su file CSV.
 * 
 * Questa classe gestisce il caricamento e il salvataggio degli elenchi dei libri, utenti e prestiti
 * su file in formato CSV.
 * 
 * @see DF-4
 * @see BF-4
 * @see FC-7
 * @author Antonio
 * @date December 04, 2025
 * @version 1.0
 */
public class Archivio {
    
    
    /**
     * @brief Costruttore di Archivio.
     * 
     * @post libri != null && libri.isEmpty()
     * @post utenti != null && utenti.isEmpty()
     * @post prestiti != null && prestiti.isEmpty()
     */
    public Archivio(){
        
    }
    
    
    /**
     * @brief Il metodo salva i dati della Biblioteca su file CSV.
     * 
     * @param[in] nomeFile Percorso del file CSV.
     * @param[in] libri Lista dei libri da salvare.
     * @param[in] utenti Lista degli utenti da salvare.
     * @param[in] prestiti Lista dei prestiti da salvare.
     * 
     * @pre nomeFile ha come estensione ".csv"
     * @pre nomeFile != null
     * @post I dati vengono scritti nel file. Se esiste, viene sovrascritto.
     * 
     * @see IF-15
     * @see FC-7
     */
    public static void salvaFileCSV(String nomeFile, List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @brief Il metodo carica i dati della biblioteca da file CSV.
     * 
     * @param[in] nomeFile Percorso del file CSV.
     * @param[out] libri Lista in cui caricare i libri.
     * @param[out] utenti Lista in cui caricare gli utenti.
     * @param[out] prestiti Lista in cui caricare i prestiti.
     * 
     * @pre nomeFile ha come estensione ".csv"
     * @pre nomeFile != null
     * @post Le liste vengono riempite con i dati passati da parametro in ingresso nomeFile.
     * 
     * @see IF-16
     * @see FC-7
     */
    public static void caricaFileCSV(String nomeFile, List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
