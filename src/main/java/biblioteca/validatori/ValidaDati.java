package biblioteca.validatori;

/**
 * @file ValidaDati.java
 * @brief L'interfaccia verifica la validità di oggetti.
 * 
 * 
 * @author Lorenzo
 * @date December 04, 2025
 * @version 1.0
 */

public interface ValidaDati<T> {
    
    /**
     * @brief Verifica che l'oggetto sia valido.
     * 
     * Il metodo consente di stabilire se l'oggetto rispetta i criteri per
     * essere registrato.
     * 
     * @param[in] object L'oggetto di cui valutare la validità. 
     * 
     * @return 'true' se l'oggetto soddisfa i requisiti, altrimenti 'false'.
    */
    public boolean isValido(T object);
    
}
