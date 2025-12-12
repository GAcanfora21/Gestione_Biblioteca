package biblioteca.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @file Archivio.java
 * @brief Questa classe gestisce il salvataggio e il caricamento dei dati su file CSV.
 * 
 * Questa classe gestisce il caricamento e il salvataggio degli elenchi dei libri, utenti e prestiti
 * su file in formato CSV.
 * 
 * @see DF-4
 * @see BF-4
 * @see FC-7
 * @author Antonio
 * @date December 04, 2025
 * @version 1.0
 */
public class Archivio {
    
    
    
    /**
     * @brief Il metodo salva i dati della Biblioteca su file CSV.
     * 
     * @param[in] nomeFile Percorso del file CSV.
     * @param[in] libri Lista dei libri da salvare.
     * @param[in] utenti Lista degli utenti da salvare.
     * @param[in] prestiti Lista dei prestiti da salvare.
     * 
     * @pre nomeFile ha come estensione ".csv"
     * @pre nomeFile != null
     * @post I dati vengono scritti nel file. Se esiste, viene sovrascritto.
     * 
     * @see IF-15
     * @see FC-7
     */
    public static void salvaFileCSV(String nomeFile, List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti){
        
        if(nomeFile == null || !nomeFile.endsWith(".csv")){
            throw new IllegalArgumentException("nome del file deve terminare con '.csv'");
        }
        
        if(libri == null || utenti == null || prestiti == null){
            throw new IllegalArgumentException("Le liste non posso essere null");
        }
        
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomeFile)))){
            
            //Sezione LIBRI
            pw.println("LIBRI");
            pw.println("TITOLO;AUTORI;ANNO_DI_PUBBLICAZIONE;CODICE_IDENTIFICATIVO;NUM_COPIE");
            for (Libro l : libri) {
                pw.append(l.getTitolo()).append(';');
                pw.append(l.getAutori()).append(';');
                pw.append(l.getAnnoDiPubblicazione()).append(';');
                pw.append(l.getCodiceIdentificativo()).append(';');
                pw.println(l.getNumCopie());
            }
            
            //Riga vuota tra sezioni
            pw.println();
            
            //Sezione UTENTI
            pw.println("UTENTI");
            pw.println("NOME;COGNOME;MATRICOLA;EMAIL;PRESTITI_ATTIVI");
            for(Utente u : utenti){
                pw.append(u.getNome()).append(';');
                pw.append(u.getCognome()).append(';');
                pw.append(u.getMatricola()).append(';');
                pw.append(u.getEmail()).append(';');
                pw.println(u.getPrestitiAttivi());
            }
            
                        
            pw.println();
            
            //Sezione PRESTITI
            pw.println("PRESTITI");
            pw.println("MATRICOLA;CODICE_IDENTIFICATIVO;DATA_RESTITUZIONE;ATTIVO");
            for(Prestito p : prestiti){
                pw.append(p.getUtente().getMatricola()).append(';');
                pw.append(p.getLibro().getCodiceIdentificativo()).append(';');
                pw.append(p.getDataRestituzione().toString());
                pw.println(p.getAttivo());
            }
            
            
            
        }catch(IOException ex){
            System.out.println("Errore durante il salvataggio del file");
            
            
        }
        
    }
    
    /**
     * @brief Il metodo carica i dati della biblioteca da file CSV.
     * 
     * @param[in] nomeFile Percorso del file CSV.
     * @param[out] libri Lista in cui caricare i libri.
     * @param[out] utenti Lista in cui caricare gli utenti.
     * @param[out] prestiti Lista in cui caricare i prestiti.
     * 
     * @pre nomeFile ha come estensione ".csv"
     * @pre nomeFile != null
     * @post Le liste vengono riempite con i dati passati da parametro in ingresso nomeFile.
     * 
     * @see IF-16
     * @see FC-7
     */
    public static void caricaFileCSV(String nomeFile, List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti){
        
        if (nomeFile == null || !nomeFile.endsWith(".csv")) {
            throw new IllegalArgumentException("Il nome del file deve terminare con '.csv'");
        }
        
        // Svuotiamo le liste per evitare duplicati se ricarichiamo
        libri.clear();
        utenti.clear();
        prestiti.clear();
        
        try(BufferedReader br = new BufferedReader(new FileReader(nomeFile))){
            
            String line;
            String currentSection = ""; //Variabile per ricordare in quale sezione siamo
            
            while((line = br.readLine()) != null){
                
                line = line.trim(); 
                if(line.isEmpty()) continue; //Salta righe vuote
                
                //Blocco che gestisce il cambio sezione
                if(line.equals("LIBRI") || line.equals("UTENTI") || line.equals("PRESTITI")) {
                    currentSection = line;
                    br.readLine();
                    continue;
                }

                String[] field = line.split(";");
                
                // 2. PARSING DEI DATI IN BASE ALLA SEZIONE CORRENTE
                switch(currentSection) {
                    case "LIBRI":
                        //Ordine: Titolo;Autori;Anno;Codice;NumCopie
                        Libro l = new Libro(field[0],field[1],(field[2]),field[3], Integer.parseInt(field[4]));
                        libri.add(l);
                        break;
                        
                    case "UTENTI":
                        //Ordine: Nome;Cognome;Matricola;Email
                        Utente u = new Utente(field[0], field[1], field[2], field[3]);
                        utenti.add(u);
                        break;
                        
                    case "PRESTITI":
                        //Ordine: MatricolaUtente;CodiceLibro;DataRestituzione;Attivo
                        String matricolaU = field[0];
                        String codiceL = field[1];
                        String dataRest = field[2];
                        boolean attivo = Boolean.parseBoolean(field[3]);
                        
                        //Per creare un Prestito, ci servono gli oggetti Utente e Libro.
                        //Dobbiamo cercarli nelle liste
                        Utente utenteTrovato = null;
                        for(Utente tempU : utenti) {
                            if(tempU.getMatricola().equals(matricolaU)) {
                                utenteTrovato = tempU;
                                break;
                            }
                        }
                        
                        Libro libroTrovato = null;
                        for(Libro tempL : libri) {
                            if(tempL.getCodiceIdentificativo().equals(codiceL)) {
                                libroTrovato = tempL;
                                break;
                            }
                        }
                        
                        // Se li abbiamo trovati entrambi, creiamo il prestito
                        if(utenteTrovato != null && libroTrovato != null) {
                            Prestito p = new Prestito(utenteTrovato, libroTrovato, dataRest, attivo);
                            prestiti.add(p);
                        }
                        break;
                }
            }
            
            
            
            
        } catch (IOException ex) {
            System.out.println("Errore durante il caricamento del file");
        }
        
    }
    
}
