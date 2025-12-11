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
 * @author Giuseppe
 */
public class GestioneLibriTest {
    
    private GestioneLibri listaLibri;
    private Libro libro;
    
    @BeforeEach
    public void setUp() {
        listaLibri = new GestioneLibri();
        libro = new Libro("Biografia", "Joe", "2025", "0123456789", 0);
        listaLibri.aggiungi(libro);
    }


    @Test
    public void testAggiungi() {
        listaLibri.aggiungi(libro);
        assertEquals(2, listaLibri.getLibri().size());
        
    }

    @Test
    public void testElimina() {
        listaLibri.elimina(libro);
        assertEquals(0, listaLibri.getLibri().size());
    }

    @Test
    public void testCerca() {
        
        ObservableList<Libro> result1 = listaLibri.cerca("biografia");
        ObservableList<Libro> result2 = listaLibri.cerca("Joe");
        ObservableList<Libro> result3 = listaLibri.cerca("0123456789");
        
        //primo caso di test, l'elemento è presente e corrisponde
        assertEquals(libro, result1.get(0));  //autore
        assertEquals(libro, result2.get(0));
        assertEquals(libro, result3.get(0));
        
        //secondo caso di test, l'elemento non è presente
        ObservableList<Libro> result4 = listaLibri.cerca("OnePiece");
        ObservableList<Libro> result5 = listaLibri.cerca("Luffy");
        ObservableList<Libro> result6 = listaLibri.cerca("1020593001");
        assertTrue(result4.isEmpty());
        assertTrue(result5.isEmpty());
        assertTrue(result6.isEmpty());
        
        
    }
    
}
