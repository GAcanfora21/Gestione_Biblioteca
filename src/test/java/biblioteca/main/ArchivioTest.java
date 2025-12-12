/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Giuseppe
 */
public class ArchivioTest {
    
    private String nomeFile;
    private Utente utente;
    private Libro libro;
    private Prestito prestito;
    
    private GestioneUtenti listaUtenti;
    private GestioneLibri listaLibri;
    private GestionePrestiti listaPrestiti;
            
    @BeforeEach
    public void setUp(){
        //inizializzazione
        listaUtenti = new GestioneUtenti();
        listaLibri = new GestioneLibri();
        listaPrestiti = new GestionePrestiti();
        
        utente = new Utente("Checco", "Zalone", "1234AB", "zalone@studenti.unisa.it", 0);
        libro = new Libro("Quo chi?", "Checco Zalone", "2022", "0123456789", 1);
        prestito = new Prestito(utente, libro, LocalDate.now().plusDays(10));
        nomeFile = "test.csv";
        
        listaUtenti.aggiungi(utente);
        listaLibri.aggiungi(libro);
        listaPrestiti.registraPrestito(prestito);
        
    }
    
    //necessario per eliminare il file creato in seguito ai test eseguiti.
    @AfterEach
    public void reset() {
        File file = new File(nomeFile);
        if(file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSalvaFileCSV() {
        Archivio.salvaFileCSV(nomeFile, listaLibri.getLibri(), listaUtenti.getUtenti(), listaPrestiti.getPrestiti());
        
        //test per verificare se il file esiste dopo il salvataggio e non è vuoto
        File file = new File(nomeFile);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
    
    

    @Test
    public void testCaricaFileCSV() {
        Archivio.salvaFileCSV(nomeFile, listaLibri.getLibri(), listaUtenti.getUtenti(), listaPrestiti.getPrestiti());
        
        //inizializzo le liste su cui andrò a caricare le relative liste dal file
        GestioneLibri libriCaricati = new GestioneLibri();
        GestioneUtenti utentiCaricati = new GestioneUtenti();
        GestionePrestiti prestitiCaricati = new GestionePrestiti();
        
        Archivio.caricaFileCSV(nomeFile, libriCaricati.getLibri(), utentiCaricati.getUtenti(), prestitiCaricati.getPrestiti());
        
    
        //primo test: verifico le dimensioni di ogni lista
        assertEquals(1, libriCaricati.getLibri().size());
        assertEquals(1, utentiCaricati.getUtenti().size());
        assertEquals(1, prestitiCaricati.getPrestiti().size());
        
        //secondo test: verifico se gli attributi di Libro corrispondono
        assertEquals(libro.getTitolo(), libriCaricati.getLibri().get(0).getTitolo());
        assertEquals(libro.getAutori(), libriCaricati.getLibri().get(0).getAutori());
        assertEquals(libro.getAnnoDiPubblicazione(), libriCaricati.getLibri().get(0).getAnnoDiPubblicazione());
        assertEquals(libro.getCodiceIdentificativo(), libriCaricati.getLibri().get(0).getCodiceIdentificativo());
        assertEquals(0, libriCaricati.getLibri().get(0).getNumCopie());         //numero di copie viene decrementato 1->0
        
        //terzo test: verifico se gli attributi di Utente corrispondono
        assertEquals(utente.getNome(), utentiCaricati.getUtenti().get(0).getNome());
        assertEquals(utente.getCognome(), utentiCaricati.getUtenti().get(0).getCognome());
        assertEquals(utente.getMatricola(), utentiCaricati.getUtenti().get(0).getMatricola());
        assertEquals(utente.getEmail(), utentiCaricati.getUtenti().get(0).getEmail());
        assertEquals(1, utentiCaricati.getUtenti().get(0).getPrestitiAttivi()); //PrestitoAttivo utente viene incrementato 0->1
        
        //quarto test: verifico se gli attributi di Prestito corrispondono
        assertEquals(prestito.getDataRestituzione(),prestitiCaricati.getPrestiti().get(0).getDataRestituzione());   
        assertEquals(prestito.getAttivo(), prestitiCaricati.getPrestiti().get(0).getAttivo());          
        assertEquals(prestito.getLibro().getCodiceIdentificativo(), libro.getCodiceIdentificativo());
        assertEquals(prestito.getUtente().getMatricola(), utente.getMatricola());
    } 
    
}
