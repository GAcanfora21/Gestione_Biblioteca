/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author Giuseppe
 */
public class BibliotecaController implements Initializable{

    @FXML
    private Tab tabDashboard;
    @FXML
    private Tab tabLibri;
    @FXML
    private Tab tabUtenti;
    @FXML
    private Tab tabPrestiti;
    @FXML
    private TextField cercaLibriField;
    @FXML
    private TextField titoloField;
    @FXML
    private TextField autoriField;
    @FXML
    private TextField annoField;
    @FXML
    private TextField copieField;
    @FXML
    private TextField codiceField;
    @FXML
    private TextField cercaUtentiField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField matricolaField;
    @FXML
    private TextField dataResoField;
    @FXML
    private TextField utentePrestitoField;
    @FXML
    private TextField libroPrestitoField;
    @FXML
    private MenuItem btnSalva;
    @FXML
    private MenuItem btnCarica;
    @FXML
    private TabPane tabMain;
    @FXML
    private Button btnGoLibri;
    @FXML
    private Button btnGoUtenti;
    @FXML
    private Button btnGoPrestiti;
    @FXML
    private Button btnCercaLibro;
    @FXML
    private TableView<Libro> libriTable;
    @FXML
    private TableColumn<Libro, String> titoloClm;
    @FXML
    private TableColumn<Libro, String> autoriClm;
    @FXML
    private TableColumn<Libro, String> annoDiPubblicazioneClm;
    @FXML
    private TableColumn<Libro, String> codiceIdentificativoClm;
    @FXML
    private TableColumn<Libro, Integer> copieClm;
    @FXML
    private Button btnAggiungiLibro;
    @FXML
    private Button btnEliminaLibro;
    @FXML
    private Button btnCercaUtente;
    @FXML
    private TableView<Utente> utentiTable;
    @FXML
    private TableColumn<Utente, String> nomeClm;
    @FXML
    private TableColumn<Utente, String> cognomeClm;
    @FXML
    private TableColumn<Utente, String> emailClm;
    @FXML
    private TableColumn<Utente, String> matricolaClm;
    @FXML
    private Button btnAggiungiUtente;
    @FXML
    private Button btnEliminaUtente;
    @FXML
    private TableView<Prestito> prestitiTable;
    @FXML
    private TableColumn<Prestito, String> utentePrestitoClm;
    @FXML
    private TableColumn<Prestito, String> libroPrestitoClm;
    @FXML
    private TableColumn<Prestito, LocalDate> dataResoClm;
    @FXML
    private TableColumn<Prestito, Boolean> restituzioneClm;
    @FXML
    private Button btnAggiungiPrestito;
    @FXML
    private ComboBox<Utente> cmbUtente;
    
    
    GestioneLibri listaLibri = new GestioneLibri();
    GestioneUtenti listaUtenti = new GestioneUtenti();
    GestionePrestiti listaPrestiti = new GestionePrestiti();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Rimuove le tab dalla lista VISIBILE
        tabMain.getTabs().remove(tabLibri);
        tabMain.getTabs().remove(tabUtenti);
        tabMain.getTabs().remove(tabPrestiti);
        
        
        //Colonne modificabili
        //1. Sezione libri
        titoloClm.setCellFactory(TextFieldTableCell.forTableColumn());
        autoriClm.setCellFactory(TextFieldTableCell.forTableColumn());
        annoDiPubblicazioneClm.setCellFactory(TextFieldTableCell.forTableColumn());
        codiceIdentificativoClm.setCellFactory(TextFieldTableCell.forTableColumn());
        copieClm.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));            
        //2. Sezione utenti
        nomeClm.setCellFactory(TextFieldTableCell.forTableColumn());
        cognomeClm.setCellFactory(TextFieldTableCell.forTableColumn());          
        matricolaClm.setCellFactory(TextFieldTableCell.forTableColumn());
        emailClm.setCellFactory(TextFieldTableCell.forTableColumn());
        //3. Sezione prestiti
        restituzioneClm.setCellFactory(CheckBoxTableCell.forTableColumn(restituzioneClm));  // La colonna 'restituzioneClm' 
                                                                                            // sarà composta da checkbox
        
            
        
        
        //Collegamento colonna-parametro
        //1. Sezione libri
        titoloClm.setCellValueFactory(new PropertyValueFactory("titolo"));
        autoriClm.setCellValueFactory(new PropertyValueFactory("autori"));
        annoDiPubblicazioneClm.setCellValueFactory(new PropertyValueFactory("annoDiPubblicazione"));
        codiceIdentificativoClm.setCellValueFactory(new PropertyValueFactory("codiceIdentificativo"));
        copieClm.setCellValueFactory(new PropertyValueFactory("numCopie"));
        //2. Sezione utenti
        nomeClm.setCellValueFactory(new PropertyValueFactory("nome"));
        cognomeClm.setCellValueFactory(new PropertyValueFactory("cognome"));
        matricolaClm.setCellValueFactory(new PropertyValueFactory("matricola"));
        emailClm.setCellValueFactory(new PropertyValueFactory("email"));
        //3. Sezione prestiti
        
        
        
        
        
        //Collegamento TableView-Liste
        libriTable.setItems(listaLibri.getLibri());
        utentiTable.setItems(listaUtenti.getUtenti());
        prestitiTable.setItems(listaPrestiti.getPrestiti());
        
        //Collegamento ComboBox-Liste
        cmbUtente.setItems(listaUtenti.getUtenti());
    }
    
    
    //Navigazione tramite tabs
    @FXML
    private void goToLibri(ActionEvent event) {
        
        //Se la tab non è attualmente visibile nel tabMain, aggiungila
        if (!tabMain.getTabs().contains(tabLibri)) {
            tabMain.getTabs().add(tabLibri);
        }
        
        tabMain.getSelectionModel().select(tabLibri);
    }

    @FXML
    private void goToUtenti(ActionEvent event) {
        
        if (!tabMain.getTabs().contains(tabUtenti)) {
            tabMain.getTabs().add(tabUtenti);
        }
        
        tabMain.getSelectionModel().select(tabUtenti);
    }

    @FXML
    private void goToPrestiti(ActionEvent event) {
        
        if (!tabMain.getTabs().contains(tabPrestiti)) {
            tabMain.getTabs().add(tabPrestiti);
        }
        
        tabMain.getSelectionModel().select(tabPrestiti);
    }

    
    
    
    
    //Modifiche Libro
    @FXML
    private void updateTitolo(TableColumn.CellEditEvent<Libro, String> event) {
        
        Libro libro = event.getRowValue();
        
        libro.setTitolo(event.getNewValue());
    }
    @FXML
    private void updateAutori(TableColumn.CellEditEvent<Libro, String> event) {
        
        Libro libro = event.getRowValue();
        
        libro.setAutori(event.getNewValue());
    }
    @FXML
    private void updateAnno(TableColumn.CellEditEvent<Libro, String> event) {
        
        Libro libro = event.getRowValue();
        
        libro.setAnnoDiPubblicazione(event.getNewValue());
    }
    @FXML
    private void updateCodice(TableColumn.CellEditEvent<Libro, String> event) {
        
        Libro libro = event.getRowValue();
        
        libro.setCodiceIdentificativo(event.getNewValue());
    }
    @FXML
    private void updateCopie(TableColumn.CellEditEvent<Libro, Integer> event) {
        
        Libro libro = event.getRowValue();
        
        libro.setNumCopie(event.getNewValue());
    }

    
    
    
    
    //Modifiche Utente
    @FXML
    private void updateNome(TableColumn.CellEditEvent<Utente, String> event) {
        
        Utente utente = event.getRowValue();
        
        utente.setNome(event.getNewValue());
    }
    @FXML
    private void updateCognome(TableColumn.CellEditEvent<Utente, String> event) {
        
        Utente utente = event.getRowValue();
        
        utente.setCognome(event.getNewValue());
    }
    @FXML
    private void updateEmail(TableColumn.CellEditEvent<Utente, String> event) {
        
        Utente utente = event.getRowValue();
        
        utente.setEmail(event.getNewValue());
    }
    @FXML
    private void updateMatricola(TableColumn.CellEditEvent<Utente, String> event) {
        
        Utente utente = event.getRowValue();
        
        utente.setMatricola(event.getNewValue());
    }

    
    
    
    
    @FXML
    private void cercaLibro(ActionEvent event) {   
    }

    @FXML
    private void aggiungiLibro(ActionEvent event) {
        
        //Libro da inserire
        Libro libro = new Libro(titoloField.getText(), autoriField.getText(), annoField.getText(), codiceField.getText(), Integer.parseInt(copieField.getText()));
         
        //Controllo validità
        ValidaDatiLibro validatoreLibro = new ValidaDatiLibro(listaLibri.getLibri());
        if(validatoreLibro.isValido(libro)){
        
            listaLibri.aggiungi(libro);
            
        }
        
    }

    @FXML
    private void eliminaLibro(ActionEvent event) {   
    }

    
    
    
    
    @FXML
    private void cercaUtente(ActionEvent event) { 
    }

    @FXML
    private void aggiungiUtente(ActionEvent event) {
        
        //Utente da inserire
        Utente utente = new Utente(nomeField.getText(), cognomeField.getText(), matricolaField.getText(), emailField.getText());
         
        //Controllo validità
        ValidaDatiUtente validatoreUtente = new ValidaDatiUtente(listaUtenti.getUtenti());
        if(validatoreUtente.isValido(utente)){
        
            listaUtenti.aggiungi(utente);
            
        }
        
    }

    @FXML
    private void eliminaUtente(ActionEvent event) {
    }

    
    
    
    
    @FXML
    private void aggiungiPrestito(ActionEvent event) {
        
        //Prestito da registrare
        //Prestito prestito = new Prestito(cmbUtente.getValue(), ...);
         
        //Controllo validità
        
    }

    
    
    
}
