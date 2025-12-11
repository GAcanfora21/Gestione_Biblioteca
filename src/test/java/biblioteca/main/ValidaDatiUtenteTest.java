/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Antonio
 */
public class ValidaDatiUtenteTest {
    
    private ValidaDatiUtente validatoreUtente;
    private ObservableList<Utente> testList;
    private Utente utente;

    @BeforeEach
    public void setUp(){
        testList = FXCollections.observableArrayList();
        utente = new Utente("A", "B", "1234AB", "test@studenti.unisa.it", 0);
        testList.add(utente);

        validatoreUtente = new ValidaDatiUtente(testList);
    }
    
    @Test
    public void testIsValido() {
        //primo caso di test, tutte le condizioni sono verificate
        //risultato atteso: 'true'
        Utente nuovoUtente0 = new Utente("Pippo", "Baudo", "1111AB", "Pippo@studenti.unisa.it", 0);
        assertTrue(validatoreUtente.isValido(nuovoUtente0));
        
        //secondo caso di test, solo la condizione Email è verificata
        //risultato atteso: 'false'
        Utente nuovoUtente1 = new Utente("Pippo", "Baudo", "1234AB", "Pippo@studenti.unisa.it", 0);
        assertFalse(validatoreUtente.isValido(nuovoUtente1));
        
        //terzo caso di test, solo la condizione UnicitàMatricola è verificata
        //risultato atteso: 'false'
        Utente nuovoUtente2 = new Utente("Pippo", "Baudo", "1111AB", "@studenti.unisa.it", 0);
        assertFalse(validatoreUtente.isValido(nuovoUtente2));
        
        
        
    }

    @Test
    public void testVerificaEmail() {
        
        //Casi validi
        //risultato atteso: 'true'
        assertTrue(validatoreUtente.verificaEmail("IronMan@studenti.unisa.it"));
        assertTrue(validatoreUtente.verificaEmail("a@studenti.unisa.it"));

        //Casi non validi
        //risultato atteso: 'false'
        assertFalse(validatoreUtente.verificaEmail("Zorro@gmail.com"));     // Dominio errato
        assertFalse(validatoreUtente.verificaEmail("Nami@unisa.it"));       // Dominio incompleto
        assertFalse(validatoreUtente.verificaEmail("@studenti.unisa.it"));  // Email incompleta
        assertFalse(validatoreUtente.verificaEmail(""));                    // Vuoto
    }

    @Test
    public void testVerificaUnicitaMatricola() {
        //Testo una matricola che non è nella lista
        //risultato atteso: 'true'
        assertTrue(validatoreUtente.verificaUnicitaMatricola("06127AB"));

        //Testo la matricola che ho messo nel setUp
        //risultato atteso: 'false'
        assertFalse(validatoreUtente.verificaUnicitaMatricola("1234AB"));
        
        //Testo la Case Insensitivity
        //risultato atteso: 'true'
        assertTrue(validatoreUtente.verificaUnicitaMatricola("06127ab"));
    }
    
}
