package biblioteca.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import biblioteca.controller.LibriController;
import biblioteca.main.Archivio;
import biblioteca.main.Archivio;
import biblioteca.main.GestioneLibri;
import biblioteca.main.GestionePrestiti;
import biblioteca.main.GestioneUtenti;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;

/**
 * Controller principale,, inizializza le varie liste di Utente,Lbro e Prestiti e 
 * gestisce il salvataggio/caricamento dei dati.
 *
 */
public class MainController implements Initializable {

    @FXML private TabPane tabMain;
    @FXML private Tab tabDashboard;
    @FXML private Tab tabLibri;
    @FXML private Tab tabUtenti;
    @FXML private Tab tabPrestiti;
    
    @FXML private MenuItem btnSalva;
    @FXML private MenuItem btnCarica;
    
    @FXML private Button btnGoLibri;
    @FXML private Button btnGoUtenti;
    @FXML private Button btnGoPrestiti;

    // Riferimento ai sotto-controller
    @FXML private LibriController libriViewController;
    @FXML private UtentiController utentiViewController;
    @FXML private PrestitiController prestitiViewController;

    // Liste Dati
    private GestioneLibri listaLibri = new GestioneLibri();
    private GestioneUtenti listaUtenti = new GestioneUtenti();
    private GestionePrestiti listaPrestiti = new GestionePrestiti();
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Passiamo le liste ai controller SOLO se i controller sono stati caricati correttamente
        if (libriViewController != null) {
            libriViewController.init(listaLibri);
        }

        if (utentiViewController != null) {
            utentiViewController.init(listaUtenti);
        }

        if (prestitiViewController != null) {
            prestitiViewController.init(listaPrestiti, listaLibri, listaUtenti, libriViewController);
        }

        // Gestione salvataggio e caricamento file
        btnSalva.setOnAction(event -> salvaFile(event));
        btnCarica.setOnAction(event -> caricaFile(event));
        
        // Rimuove tab all'avvio
        tabMain.getTabs().removeAll(tabLibri, tabUtenti, tabPrestiti);
    }

    // Navigazione tra le tab
    @FXML
    private void goToLibri(ActionEvent event) {
        if (!tabMain.getTabs().contains(tabLibri)) tabMain.getTabs().add(tabLibri);
        tabMain.getSelectionModel().select(tabLibri);
    }
    @FXML
    private void goToUtenti(ActionEvent event) {
        if (!tabMain.getTabs().contains(tabUtenti)) tabMain.getTabs().add(tabUtenti);
        tabMain.getSelectionModel().select(tabUtenti);
    }
    @FXML
    private void goToPrestiti(ActionEvent event) {
        if (!tabMain.getTabs().contains(tabPrestiti)) tabMain.getTabs().add(tabPrestiti);
        tabMain.getSelectionModel().select(tabPrestiti);
    }
    
    @FXML
    private void salvaFile(ActionEvent event){
        
        String percorso = "./salvataggi/";
        //Assicuriamoci che la cartella esista, altrimenti la creiamo
        File cartella = new File(percorso);
        if (!cartella.exists()) {
            cartella.mkdir();
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(percorso)); 
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));
        fileChooser.setInitialFileName("nomefile.csv");

        //Mostra la finestra di salvataggio
        File file = fileChooser.showSaveDialog(tabMain.getScene().getWindow());
        
        //mi evita messaggi di errore quando l'utente clicca annulla
        if(file != null){
        try{
        Archivio.salvaFileCSV(file.getAbsolutePath(), listaLibri.getLibri(), listaUtenti.getUtenti(), listaPrestiti.getPrestiti());
            mostraAlert(Alert.AlertType.INFORMATION, "File salvato con successo");
        } catch (Exception ex){
            mostraAlert(Alert.AlertType.ERROR, "Errore nel salvtaggio del File");
        }
        }
     }
    
    @FXML
    private void caricaFile(ActionEvent event){
        
        String percorso = "./salvataggi/";
        File cartella = new File(percorso);
        
        if (!cartella.exists()) {
            cartella.mkdir();
        }
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(cartella);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));

        //Mostra la finestra di caricamento
        File file = fileChooser.showOpenDialog(tabMain.getScene().getWindow());

        //mi evita messaggi di errore quando l'utente clicca annulla 
        if (file != null) {
        try{
        Archivio.caricaFileCSV(file.getAbsolutePath(), listaLibri.getLibri(), listaUtenti.getUtenti(), listaPrestiti.getPrestiti());
            mostraAlert(Alert.AlertType.INFORMATION, "File caricato con successo");
        } catch (Exception ex){
            mostraAlert(Alert.AlertType.ERROR, "Errore nel caricamento del File");
        }
        }
     
    }
    
    private void mostraAlert(Alert.AlertType type, String messaggio) {
        Alert alert = new Alert(type);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
}
