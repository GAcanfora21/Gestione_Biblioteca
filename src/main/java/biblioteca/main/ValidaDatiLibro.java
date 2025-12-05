package biblioteca.main;

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
    
    
    
    
    
    
    /**
     * @brief Verifica se dati del libro inserito siano validi
     * 
     * Questo metodo verifica che i dati di un libro rispettino i vincoli:
     * 1. Sia nel formato corretto (10 cifre) tramite verificaCodiceIdentificativo()
     * 2. Sia univoco nell'archivio tramite verificaUnicitaCodice()
     * 
     * @pre libro != null.
     * @post se return == false stampa messaggioErrore().
     * 
     * @param[in] libro il libro da validare.
     * @return 'true' se il libro supera tutti i controlli, 'false' altrimenti.
     */
    public boolean isValido(Libro libro){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    
    /**
     * @brief Verifica il formato del codice identificativo: 10 cifre (FC-3).
     * 
     * 
     * @pre 'codice != null', il parametro d'ingresso deve essere non nullo.
     * 
     * @param[in] codice codice da validare.
     * @return 'true' se il formato codice è corretto, 'false' altrimenti.
     */
    private boolean verificaCodiceIdentificativo(String codice){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * @brief Unicità codice identificativo nell'archivio (FC-3, IF-1).
     * 
     * 
     * @pre 'codice != null' il parametro d'ingresso deve essere non nullo.
     * 
     * @param[in] codice codice da validare.
     * @return 'true' se il codice è univoco, 'false' altrimenti.
     */
    private boolean verificaUnicitaCodice(String codice){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
