/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Giuseppe
 */
public class GestioneUtentiTest {
    
    private GestioneUtenti listaUtenti;
    private Utente utente;
    
    public GestioneUtentiTest() {
    }

    @BeforeEach
    public void setUp(){
        listaUtenti = new GestioneUtenti();
        utente = new Utente("G", "Acanfora", "matricola", "test@studenti.unisa.it");
        listaUtenti.aggiungi(utente);
    }

    @Test
    public void testAggiungi() {
        listaUtenti.aggiungi(utente);
        assertEquals(2, listaUtenti.getUtenti().size());
    }

    @Test
    public void testElimina() {
        listaUtenti.elimina(utente);
        assertEquals(0, listaUtenti.getUtenti().size());
    }

    @Test
    public void testCerca() {
        
        ObservableList<Utente> result1 = listaUtenti.cerca("Acanfora");
        ObservableList<Utente> result2 = listaUtenti.cerca("matricola");
        
        //primo caso di test, l'elemento è presente è corrisponde
        assertEquals(utente, result1.get((0)));
        assertEquals(utente, result2.get((0)));
        
        //secondo caso di test, l'elemento non è presente
        ObservableList<Utente> result3 = listaUtenti.cerca("Luffy");
        ObservableList<Utente> result4 = listaUtenti.cerca("X");
        assertTrue(result3.isEmpty());
        assertTrue(result4.isEmpty());
        
    }
    
}
