package biblioteca.main;

/**
 * @file Libro.java
 * @brief Definisce attributi e metodi della classe Libro.
 * 
 * @invariant titolo != null
 * @invariant autori != null
 * @invariant annoDiPubblicazione != null
 * @invariant codiceIdentificativo != null && codiceIdentificativo.length() == 10
 * @invariant numCopie >= 0
 * 
 * 
 * @see IF-1
 * @see IF-2
 * @see DF-2
 * @author Antonio
 * @date December 04, 2025
 * @version 1.0
 */
public class Libro {
    
    private String titolo;
    private String autori;
    private String annoDiPubblicazione;
    private String codiceIdentificativo;
    private int numCopie;
    
    /**
     * @brief Costruttore di Libro
     * 
     * @param[in] titolo Titolo del libro.
     * @param[in] autori Autori del libro.
     * @param[in] annoDiPubblicazione Anno di pubblicazione.
     * @param[in] codiceIdentificativo Codice univoco (10 cifre).
     * @param[in] numCopie Numero di copie disponibili.
     */
    public Libro(String titolo, String autori, String annoDiPubblicazione, String codiceIdentificativo, int numCopie){
        this.titolo = titolo;
        this.autori = autori;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.codiceIdentificativo = codiceIdentificativo;
        this.numCopie = numCopie;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutori() {
        return autori;
    }

    public String getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public String getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    public int getNumCopie() {
        return numCopie;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutori(String autori) {
        this.autori = autori;
    }

    public void setAnnoDiPubblicazione(String annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public void setCodiceIdentificativo(String codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public void setNumCopie(int numCopie) {
        this.numCopie = numCopie;
    }
    

    /**
     * @brief Incrementa il numero di copie dell'istanza di un libro
     * 
     * @post libro.numCopie = libro.numCopie + 1
     */
    public void aggiungiCopie(){
        
        this.numCopie++;
    }
    
    /**
     * @brief Decrementa di 1 il numero di copie dell'istanza di un libro.
     * 
     * @post libro.numCopie = libro.numCopie - 1
     */
    public void rimuoviCopie(){
        
        this.numCopie--;
    }
    
    
    @Override
    public String toString(){
        return "Titolo: " + this.titolo + "Autore/i: " + this.autori + "Anno di pubblicazione: " +
                this.annoDiPubblicazione + "Codice identificativo: " + this.codiceIdentificativo + "Numero Copie: " + this.numCopie;
    }
    
}