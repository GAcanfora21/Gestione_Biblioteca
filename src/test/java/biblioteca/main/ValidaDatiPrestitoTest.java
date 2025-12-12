/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Enrico
 */
public class ValidaDatiPrestitoTest {

    private ValidaDatiPrestito validaP;
    private Prestito prestito;
    private Utente u;
    private Libro l;
    private LocalDate d;
    
    @BeforeEach
    public void setUp(){
        validaP = new ValidaDatiPrestito();
        
        u = new Utente("Alberto", "Smith", "23", "e@mail");
        u.setPrestitiAttivi(2);
        l = new Libro("LOTR", "Tolkien", "2005", "59", 1);
        prestito = new Prestito(u,l,d);
    }
    
    @Test
    public void testIsValido() {    
        //Primo caso di test, tutte le condizioni sono verificate
        //Risultato atteso: 'true'     
        u.setPrestitiAttivi(2);
        l.setNumCopie(1);
        
        assertTrue(validaP.isValido(prestito));
        
        
        //Secondo caso di test
        //verificaLimitePrestito = 'false' 
        //verificaDisponibilitaCopie = 'true'
        //Risultato atteso: 'false'
        u.setPrestitiAttivi(3);
        l.setNumCopie(1);
        
        assertFalse(validaP.isValido(prestito));
        
        
        //Terzo caso di test
        //verificaLimitePrestito = 'true' 
        //verificaDisponibilitaCopie = 'false'
        //Risultato atteso: 'false'
        u.setPrestitiAttivi(2);
        l.setNumCopie(0);
        
        assertFalse(validaP.isValido(prestito));
    }

    @Test
    public void testVerificaLimitePrestito() {
        //Primo caso di test, il numero di prestiti attivi è < 3
        assertTrue(validaP.verificaLimitePrestito(2));
        
        //Secondo caso di test, il numero di prestiti attivi è >= 3
        assertFalse(validaP.verificaLimitePrestito(3));
    }

    @Test
    public void testVerificaDisponibilitaCopie() {
        //Primo caso di test, il numero di copie disponibili è > 0
        assertTrue(validaP.verificaDisponibilitaCopie(2));
        
        //Secondo caso di test, il numero di copie disponibili è = 0
        assertFalse(validaP.verificaDisponibilitaCopie(0));
    }
    
}
