/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionebiblioteca;

import java.util.List;

/**
 *
 * @author Giuseppe
 */
public class Utente {
    private String nome;
    private String cognome;
    private String matricola;
    private String email;
    private List<Prestito> prestitiAttivi;
    
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCognome(){
        return this.cognome;
    }
    
    public String getMatricola(){
        return this.matricola;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public List<Prestito> getPrestitiAttivi(){
        return this.prestitiAttivi;
    }
    
    /**
     * @brief Aggiungi il prestito.
     * 
     * Tale metodo consente di aggiungere un prestito all'elenco di libri prestati 
     * all'utente.
     * 
     * @param[in] prestito Il prestito da aggiungere.
     * 
     * @pre L'utente non ha raggiunto il limite di prestiti.
     * @post Il prestito viene aggiunto all'elenco prestiti dell'utente.
     * 
     * @see DF-1
     * @see verificaLimitePrestito(Utente utente).
    */
    public void aggiungiPrestito(Prestito prestito){
        
    }
    
    /**
     * @brief Rimuovi il prestito.
     * 
     * Tale metodo consente di rimuovere un prestito dall'elenco di libri prestati 
     * all'utente.
     * 
     * @param[in] prestito Il prestito da rimuovere.
     * 
     * @pre Il prestito è presente nell'elenco prestiti dell'utente.
     * @post Il prestito viene rimosso dall'elenco prestiti dell'utente.
     * 
     *
     * @see IF-8
    */
    public void rimuoviPrestito(Prestito prestito){
        
    }
    
    @Override
    public String toString(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
    
