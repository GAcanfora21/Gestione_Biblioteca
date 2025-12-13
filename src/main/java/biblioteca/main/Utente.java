package biblioteca.main;

import java.util.List;

/**
 * @file Utente.java
 * @brief Definisce attributi e metodi della classe Utente.
 * 
 * @invariant nome != null
 * @invariant cognome != null
 * @invariant matricola != null
 * @invariant email != null
 * @invariant prestitiAttivi >= 0
 * 
 * @see Prestito
 * @see DF-1
 * @see IF-8
 * @author Lorenzo
 * @date December 04, 2025
 * @version 1.0
 */
public class Utente {
    private String nome;
    private String cognome;
    private String matricola;
    private String email;
    private int prestitiAttivi;
    
    public Utente(String nome, String cognome, String matricola, String email){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.email = email;
        this.prestitiAttivi = 0;
    }
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
    
    public int getPrestitiAttivi(){
        return this.prestitiAttivi;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrestitiAttivi(int prestitiAttivi) {
        this.prestitiAttivi = prestitiAttivi;
    }
    
    
    /**
     * @brief Aggiunge un prestito.
     * 
     * Il metodo permette di incrementare il numero di prestiti attivi dell'utente.
     * 
     * 
     * @pre L'utente non ha raggiunto il limite di prestiti attivi.
     * @post Il numero di prestiti attivi dell'utente è aumentato di 1.
     * 
     * @see DF-1
     * @see verificaLimitePrestito().
    */
    public void incrementaPrestiti(){
        this.prestitiAttivi++;
        
    }
    
    /**
     * @brief Rimuove un prestito.
     * 
     * Il metodo permette di decrementare il numero di prestiti attivi dell'utente.
     * 
     * 
     * @pre 'prestitiAttivi > 0'
     * @post Il numero di prestiti attivi dell'utente è diminuito di 1.
     * 
     *
     * @see IF-8
    */
    public void decrementaPrestiti(){
        if (this.prestitiAttivi > 0) {
            this.prestitiAttivi--;
        }
        
    }
    
    @Override
    public String toString(){
        return "" + nome + " " + cognome + " (Matricola: " + matricola + ")";
    }
}
    
