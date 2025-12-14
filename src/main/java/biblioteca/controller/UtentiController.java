package biblioteca.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import biblioteca.main.GestioneUtenti;
import biblioteca.main.Utente;
import biblioteca.validatori.ValidaDatiUtente;
import biblioteca.validatori.MessaggiDiControllo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 */
public class UtentiController implements Initializable {

    @FXML private TableView<Utente> utentiTable;
    @FXML private TableColumn<Utente, String> nomeClm;
    @FXML private TableColumn<Utente, String> cognomeClm;
    @FXML private TableColumn<Utente, String> emailClm;
    @FXML private TableColumn<Utente, String> matricolaClm;

    @FXML private TextField cercaUtentiField;
    @FXML private TextField nomeField;
    @FXML private TextField cognomeField;
    @FXML private TextField emailField;
    @FXML private TextField matricolaField;
    
    @FXML private Button btnAggiungiUtente;
    @FXML private Button btnEliminaUtente;
    @FXML private Button btnCercaUtente;

    private GestioneUtenti listaUtenti;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Collegamento colonna-parametro di Utenti
        nomeClm.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cognomeClm.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        emailClm.setCellValueFactory(new PropertyValueFactory<>("email"));
        matricolaClm.setCellValueFactory(new PropertyValueFactory<>("matricola"));

        // Celle modificabili
        nomeClm.setCellFactory(TextFieldTableCell.forTableColumn());
        cognomeClm.setCellFactory(TextFieldTableCell.forTableColumn());
        emailClm.setCellFactory(TextFieldTableCell.forTableColumn());
        matricolaClm.setCellFactory(TextFieldTableCell.forTableColumn());
        
        cercaUtente();
    }

    public void init(GestioneUtenti listaUtenti) {
        this.listaUtenti = listaUtenti;
        utentiTable.setItems(listaUtenti.getUtenti());
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
    
    
    
    public void cercaUtente() {
        
        //Gestione del cambiamento della lista utenti quando si effettua la ricerca nel textfield 'cercaUtentiField'
        cercaUtentiField.textProperty().addListener((observable, vecchioValore, nuovoValore) -> {
            
            if (vecchioValore == null || nuovoValore.trim().isEmpty()) {
                // Ripristina la lista originale completa
                utentiTable.setItems(listaUtenti.getUtenti());
            }else{
                utentiTable.setItems(listaUtenti.cerca(nuovoValore)); //Mi permette di cercare automaticamente mentre scrivo nel textfield
            }
        });
    }

    @FXML
    private void aggiungiUtente(ActionEvent event) {
        
        //Utente da inserire
        Utente utente = new Utente(nomeField.getText(), cognomeField.getText(), matricolaField.getText(), emailField.getText());
         
        //Controllo validità
        ValidaDatiUtente validatoreUtente = new ValidaDatiUtente(listaUtenti.getUtenti());
        if(validatoreUtente.isValido(utente)){
        
            listaUtenti.aggiungi(utente);
            
            nomeField.clear();
            cognomeField.clear();
            matricolaField.clear();
            emailField.clear();
            
        }else if(nomeField.getText().isEmpty() || cognomeField.getText().isEmpty() || emailField.getText().isEmpty() || matricolaField.getText().isEmpty()){
            MessaggiDiControllo.mostraAlert(Alert.AlertType.ERROR, "Inserisci tutti i campi presenti");
        }else{
            MessaggiDiControllo.mostraAlert(Alert.AlertType.ERROR, "Formato email non valida/Matricola già presente:\n"
                    + "1) Dominio email accettato: *@studenti.unisa.it.\n"
                    + "2) La matricola deve essere univoca.");      
        }
        
    }

    @FXML
    private void eliminaUtente(ActionEvent event) {
        
        Utente utente = utentiTable.getSelectionModel().getSelectedItem();
        
        if(utente.getPrestitiAttivi() > 0){
            MessaggiDiControllo.mostraAlert(Alert.AlertType.ERROR, "Non è possibile cancellare un utente che ha un prestito attivo");
            return;
        }
        
        listaUtenti.elimina(utente);
        
        String testo = cercaUtentiField.getText();
        
        if(testo != null && !testo.isEmpty()){
            utentiTable.setItems(listaUtenti.cerca(testo)); //forzo il ricalcolo della ricerca sulla lista una volta che l'elemento è stato eliminato
        }
    }
    
}

