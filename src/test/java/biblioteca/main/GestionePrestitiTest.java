/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Enrico
 */
public class GestionePrestitiTest {
    
    private GestionePrestiti lista;
    private Prestito prestito;
    private Utente u;
    private Libro l;
    private LocalDate d;
    
    @BeforeEach
    public void setUp(){
        lista = new GestionePrestiti(); 
        u = new Utente("Alberto", "Smith", "23", "e@mail");
        l = new Libro("LOTR", "Tolkien", "2005", "59", 5);
        prestito = new Prestito(u,l,d);
    }

    @Test
    public void testRegistraPrestito(){
        
        //Primo caso di test
        //copie disponibili = 0 
        //prestiti attivi < 3
        //Risultato atteso: fallita aggiunta di 1 elemento nella lista (size = 0)
        l.setNumCopie(0);
        u.setPrestitiAttivi(2);
        lista.registraPrestito(prestito);
        assertEquals(0, lista.getPrestiti().size());
        
        
        //Secondo caso di test
        //copie disponibili > 0 
        //prestiti attivi = 3
        //Risultato atteso: fallita aggiunta di 1 elemento nella lista (size = 0)
        l.setNumCopie(1);
        u.setPrestitiAttivi(3);
        lista.registraPrestito(prestito);
        assertEquals(0, lista.getPrestiti().size());
        
        
        //Terzo caso di test
        //copie disponibili > 0 
        //prestiti attivi < 3
        //Risultato atteso: aggiunta di 1 elemento nella lista (size = 1)
        l.setNumCopie(1);
        u.setPrestitiAttivi(2);
        lista.registraPrestito(prestito);
        assertEquals(1, lista.getPrestiti().size());
        
        
    }

    @Test
    public void testRegistraRestituzione() {
        
        lista.registraRestituzione(prestito);
        assertFalse(prestito.getAttivo());
    }
    
}
