package biblioteca.main;

import javafx.collections.ObservableList;

/**
 * @file ValidaDatiPrestito.java
 * @brief Verifica la validità di un prestito.
 * 
 * @see IF-11
 * @author Enrico
 * @date December 02, 2025
 * @version 1.0
 */
public class ValidaDatiPrestito implements ValidaDati<Prestito>{
    
    /**  
     * @brief Verifica che il prestito sia valido.
     * 
     * Il metodo consente di stabilire se il prestito rispetta i criteri per essere registrato. 
     * 
     * @param[in] prestito Il prestito di cui valutare la validità.
     * 
     * @return 'true' se il prestito soddisfa i requisiti definiti in IF-11, 'false' altrimenti.
     * 
     * @see IF-11
     * @see verificaLimitePrestito()
     * @see verificaDisponibilitàCopie()
     */
    public boolean isValido(Prestito prestito){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    /**  
     * @brief Verifica se l'utente ha già tre prestiti attivi.
     * 
     * Il metodo permette di verificare che l'utente non abbia raggiunto il massimo numero di prestiti in contemporanea. 
     * 
     * @param[in] prestitiUtente Il numero dei prestiti dell'utente.
     * 
     * @return 'true' se l'utente presenta meno di tre prestiti attivi, 'false' altrimenti.
     * 
     * @see IF-11
     */
    public boolean verificaLimitePrestito(int prestitiUtente){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**  
     * @brief Verifica se ci sono copie del libro.
     * 
     * Il metodo permette di verificare se le copie del libro da prestare non sono esaurite. 
     * 
     * @param[in] numCopie Il numero di copie del libro.
     * 
     * @return 'true' se il libro dispone di almeno una copia, 'false' se il numero di copie è pari a zero.
     * 
     * @see IF-11
     */
    public boolean verificaDisponibilitaCopie(int numCopie){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
