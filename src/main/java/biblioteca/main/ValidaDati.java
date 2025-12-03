/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

/**
 *
 * @author Giuseppe
 */

public interface ValidaDati<T> {
    
    /**
     * @brief Verifica che l'oggetto sia valido.
     * 
     * Il metodo consente di stabilire se l'oggetto rispetta i criteri per
     * essere registrato.
     * 
     * @param[in] o L'oggetto di cui valutare la validità. 
     * 
     * @return 'true' se l'oggetto soddisfa i requisiti, altrimenti 'false'.
    */
    public boolean isValido(T object);
    
}
