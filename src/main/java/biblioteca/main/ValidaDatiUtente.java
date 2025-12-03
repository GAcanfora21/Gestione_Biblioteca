/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

/**
 * @file ValidaDatiUtente.java
 * @brief Verifica la validità di un utente.
 * 
 * @see IF-6
 * @see FC-4
 * @see FC-5
 * @author Enrico
 * @date December 02, 2025
 * @Version 1.0
 */
public class ValidaDatiUtente implements ValidaDati<Utente>{
    
    /**  
     * @brief Verifica che l'utente sia valido.
     * 
     * Il metodo consente di stabilire se l'utente rispetta i criteri per essere registrato. 
     * 
     * @param[in] utente L'utente da esaminare.
     * 
     * @return 'true' se l'utente soddisfa i requisiti definiti in IF-6, 'false' altrimenti.
     * 
     * @see IF-6
     * @see verificaEmail(Utente utente)
     * @see verificaUnicitàMatricola(Utente utente)
     */
    @Override
    public boolean isValido(Utente utente){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    /**  
     * @brief Verifica se l'email è valida.
     * 
     * Il metodo permette di verificare che l'email rispetti i criteri descritti in FC-5. 
     * 
     * @param[in] utente L'utente di cui esaminare l'email.
     * 
     * @return 'true' se l'email rispetta il formato corretto, 'false' altrimenti.
     * 
     * @see FC-5
     */
    public boolean verificaEmail(Utente utente){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    /**  
     * @brief Verifica se la matricola è valida.
     * 
     * Il metodo permette di verificare che la matricola rispetti i criteri descritti in FC-4. 
     * 
     * @param[in] utente L'utente di cui esaminare la matricola.
     * 
     * @return 'true' se la matricola è unica, 'false' altrimenti.
     * 
     * @see FC-4
     */
    public boolean verificaUnicitàMatricola(Utente utente){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
