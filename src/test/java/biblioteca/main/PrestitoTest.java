/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Enrico
 */
public class PrestitoTest {
    
    private Utente u;
    private Libro l;
    private LocalDate d = LocalDate.of(2024, Month.MARCH, 3);
    
    private Prestito p;
    
    @BeforeEach
    public void setUp(){
        p = new Prestito(u,l,d);
        
    }

    @Test
    public void testIsRitardo() {
        assertTrue(p.isRitardo());
    }
    
}
