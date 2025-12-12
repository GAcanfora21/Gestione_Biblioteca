/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Antonio
 */
public class UtenteTest {
    
    private Utente u;
    
    @BeforeEach
    public void setUp(){
        // Creiamo l'utente con 1 prestito iniziale
        u = new Utente("Antonio", "Crisci", "0612709486", "a.crisci14@studenti.unisa.it");
        u.setPrestitiAttivi(1);
    }

    @Test
    public void testIncrementaPrestiti() {
        System.out.println("Test Incrementa");
        // Prestiti attuali: 1. Dopo incremento: deve essere 2.
        u.incrementaPrestiti();
        assertEquals(2, u.getPrestitiAttivi());
    }

    @Test
    public void testDecrementaPrestiti() {
        System.out.println("Test Decrementa");
        // Prestiti attuali: 1. Dopo decremento: deve essere 0.
        u.decrementaPrestiti();
        assertEquals(0, u.getPrestitiAttivi());
    }
    
}
