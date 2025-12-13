package biblioteca.validatori;

import biblioteca.main.Utente;
import javafx.collections.ObservableList;

/**
 * @file ValidaDatiUtente.java
 * @brief Verifica la validità di un utente.
 * 
 * @see IF-6
 * @see FC-4
 * @see FC-5
 * @author Enrico
 * @date December 02, 2025
 * @version 1.0
 */
public class ValidaDatiUtente implements ValidaDati<Utente>{
    
    
    // Campo necessario per controllare l'unicità della matricola
    private ObservableList<Utente> listaUtenti;

    /**
     * @brief Costruttore che riceve la lista degli utenti attuali. Necessario per verificare i duplicati.
     * @param[in] listaUtenti La lista attuale degli utenti registrati.
     */
    public ValidaDatiUtente(ObservableList<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }
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
     * @see verificaEmail()
     * @see verificaUnicitaMatricola()
     */
    @Override
    public boolean isValido(Utente utente){
        
        //Controlli necessari per evitare di verificare valori null
        if(utente == null) return false;
        
        boolean emailIsValid=false, matricolaIsValid=false;
        
        if(utente.getEmail() != null && !utente.getEmail().isEmpty()){
            emailIsValid = verificaEmail(utente.getEmail());
        }
        
        if(utente.getMatricola() != null && !utente.getMatricola().isEmpty()){
            matricolaIsValid = verificaUnicitaMatricola(utente.getMatricola());
        }
        
        
        return emailIsValid && matricolaIsValid;
    }
    
    
    
    /**  
     * @brief Verifica se l'email è valida.
     * 
     * Il metodo permette di verificare che l'email rispetti i criteri descritti in FC-5. 
     * 
     * @param[in] email L'email di cui verificare il formato.
     * 
     * @return 'true' se l'email rispetta il formato corretto, 'false' altrimenti.
     * 
     * @see FC-5
     */
    public boolean verificaEmail(String email){
        
        String dominio = "@studenti.unisa.it";
        
        if (!email.endsWith(dominio)) return false;
        
        //L'email deve essere più lunga del solo dominio. In caso contrario l'email
        //sarà esattamente @studenti.unisa.it, e ciò non è accettabile.
        return email.length() > dominio.length();
    }
    
    
    /**  
     * @brief Verifica se la matricola è valida.
     * 
     * Il metodo permette di verificare che la matricola rispetti i criteri descritti in FC-4. 
     * 
     * @param[in] matricola La matricola di cui verificare l'unicità.
     * 
     * @return 'true' se la matricola è unica, 'false' altrimenti.
     * 
     * @see FC-4
     */
    public boolean verificaUnicitaMatricola(String matricola){
        
        for(Utente u : listaUtenti){
            if(u.getMatricola().equalsIgnoreCase(matricola)) return false;
        }
        return true;
    }
}
