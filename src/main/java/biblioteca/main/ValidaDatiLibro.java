package biblioteca.main;

import javafx.collections.ObservableList;

/**
 * @file ValidaDatiLibro.java
 * @brief Verifica il formato e l'univocità dell'identificativo di un libro.
 * 
 * Questa classe stabilisce se il dati Libro inseriti rispettano i criteri definiti in FC-3.
 * 
 * @see FC-3
 * @see IF-1
 * @see Libro
 * @see ValidaDati
 * @author Giuseppe
 * @date December 03, 2025
 * @version 1.0
 */
public class ValidaDatiLibro implements ValidaDati<Libro> {
    
    
    // Campo necessario per controllare l'unicità del codice
    private ObservableList<Libro> listaLibri;

    /**
     * @brief Costruttore che riceve la lista dei libri attuali. Necessario per verificare i duplicati.
     * @param[in] listaLibri La lista attuale dei libri registrati.
     */
    public ValidaDatiLibro(ObservableList<Libro> listaLibri) {
        this.listaLibri = listaLibri;
    }
    
    /**
     * @brief Verifica se dati del libro inserito siano validi.
     * 
     * Questo metodo verifica che i dati di un libro rispettino i vincoli:
     * 1. Sia nel formato corretto (10 cifre) tramite verificaFormatoCodice()
     * 2. Sia univoco nell'archivio tramite verificaUnicitaCodice()
     * 
     * @pre libro != null.
     * @post se return == false mostra un messaggio di errore.
     * 
     * @param[in] libro Il libro da validare.
     * @return 'true' se il libro supera tutti i controlli, 'false' altrimenti.
     */
    public boolean isValido(Libro libro){
        
        if(libro == null) return false;
             
        boolean formatoIsValido=false, codiceIsUnico=false;
        
        String codice = libro.getCodiceIdentificativo();
        
        //Controlla che ci sia un codice da verificare
        if(libro.getCodiceIdentificativo() != null && !libro.getCodiceIdentificativo().isEmpty()){
            formatoIsValido = verificaFormatoCodice(codice);
            codiceIsUnico = verificaUnicitaCodice(codice);
        }
        
        return formatoIsValido && codiceIsUnico;
    } 
    
    
    /**
     * @brief Verifica il formato del codice identificativo: 10 cifre (FC-3).
     * 
     * 
     * @pre 'codice != null', il parametro d'ingresso deve essere non nullo.
     * 
     * @param[in] codice Codice da validare.
     * @return 'true' se il formato codice è corretto, 'false' altrimenti.
     */
    public boolean verificaFormatoCodice(String codice){
      
        if (codice.length()!=10) return false;
        
        return true;
    }
    
    
    /**
     * @brief Unicità codice identificativo nell'archivio (FC-3, IF-1).
     * 
     * 
     * @pre 'codice != null' il parametro d'ingresso deve essere non nullo.
     * 
     * @param[in] codice Codice da validare.
     * @return 'true' se il codice è univoco, 'false' altrimenti.
     */
    public boolean verificaUnicitaCodice(String codice){
        
        for(Libro l : listaLibri){
            if(l.getCodiceIdentificativo().equalsIgnoreCase(codice)) return false;
        }
        
        return true;
    }
}
