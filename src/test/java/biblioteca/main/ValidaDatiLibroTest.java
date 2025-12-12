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
 * @author Lorenzo
 */
public class ValidaDatiLibroTest {
    
    private ValidaDatiLibro validaLibro;
    private ObservableList<Libro> listaLibri;
    private Libro libro;
    
    @BeforeEach
    public void setUp(){
        listaLibri = FXCollections.observableArrayList();
        libro = new Libro("Harry Potter", "John", "2010", "1234567890", 1);
        listaLibri.add(libro);

        validaLibro = new ValidaDatiLibro(listaLibri);
    }
    
    @Test
    public void testIsValido() {
        
        //Primo caso di test, tutte le condizioni sono verificate
        //Risultato atteso: 'true'     
        Libro nuovoLibro1 = new Libro("Harry Potter2", "Mark", "2015", "0612710152", 6);
        
        assertTrue(validaLibro.isValido(nuovoLibro1));
        
        
        //Secondo caso di test
        //verificaFormatoCodice = 'false' 
        //verificaUnicitaCodice = 'true'
        //Risultato atteso: 'false'
        Libro nuovoLibro2 = new Libro("Harry Potter2", "Mark", "2015", "12", 6);
        
        assertFalse(validaLibro.isValido(nuovoLibro2));
        
        
        //Terzo caso di test
        //verificaFormatoCodice = 'true' 
        //verificaUnicitaCodice = 'false'
        //Risultato atteso: 'false'
        Libro nuovoLibro3 = new Libro("Harry Potter2", "Mark", "2015", "1234567890", 6);
        
        assertFalse(validaLibro.isValido(nuovoLibro3));
    }

    @Test
    public void testVerificaFormatoCodice() {
        //Primo caso di test, codice corretto: 10 cifre
        //Risultato atteso: 'true' 
        assertTrue(validaLibro.verificaFormatoCodice("1234567890"));
        
        //Secondo caso di test, codice non lungo 10 cifre
        //Risultato atteso: 'false' 
        assertFalse(validaLibro.verificaFormatoCodice("1234"));
        assertFalse(validaLibro.verificaFormatoCodice("12345678900")); 
    }

    @Test
    public void testVerificaUnicitaCodice() {
        
        //Primo caso di test
        //Codice non presente nella lista (correttamente univoco)
        //Risultato atteso: 'true'
        assertTrue(validaLibro.verificaUnicitaCodice("1234567899"));

        //Secondo caso di test
        //Codice presente nella lista (non univoco)
        //Risultato atteso: 'false'
        assertFalse(validaLibro.verificaUnicitaCodice("1234567890"));
        
        
    }
    
}
