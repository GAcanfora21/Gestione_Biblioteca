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
 * @author Lorenzo
 */
public class LibroTest {
    
    private Libro l;
    
    @BeforeEach
    public void setUp(){
        l = new Libro("Harry Potter", "John", "2010", "1234567890", 1);
    }

    @Test
    public void testAggiungiCopie() {
        l.aggiungiCopie();
        assertEquals(2, l.getNumCopie());
    }

    @Test
    public void testRimuoviCopie() {
        l.rimuoviCopie();
        assertEquals(0, l.getNumCopie());
    }

    
    
}
