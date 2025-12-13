package biblioteca.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 */
public class PrestitiController implements Initializable {

    @FXML private TableView<Prestito> prestitiTable;
    @FXML private TableColumn<Prestito, String> utentePrestitoClm;
    @FXML private TableColumn<Prestito, String> libroPrestitoClm;
    @FXML private TableColumn<Prestito, LocalDate> dataResoClm;
    @FXML private TableColumn<Prestito, Boolean> restituzioneClm;
    
    @FXML private Button btnAggiungiPrestito;
    @FXML private DatePicker dataRest;
    @FXML private ComboBox<Utente> comboUtente;
    @FXML private ComboBox<Libro> comboLibro;
    
    private GestionePrestiti listaPrestiti;
    private GestioneLibri listaLibri;
    private GestioneUtenti listaUtenti;

    // Aggiunto un riferimento al Controller dei Libri per poter aggiornare la sua tabella
    private LibriController libriController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Collegamento colonna-parametro di Utente
        utentePrestitoClm.setCellValueFactory(new PropertyValueFactory<>("utente"));
        libroPrestitoClm.setCellValueFactory(new PropertyValueFactory<>("libro"));
        dataResoClm.setCellValueFactory(new PropertyValueFactory<>("dataRestituzione"));
        
        checkRitardo();
        spuntaRestituzione();
        
        
        
    }    
    
    // inizializza la lista prestiti
    public void init(GestionePrestiti listaPrestiti, GestioneLibri listaLibri, GestioneUtenti listaUtenti, LibriController libriController) {
        this.listaPrestiti = listaPrestiti;
        this.listaLibri = listaLibri;
        this.listaUtenti = listaUtenti;
        this.libriController = libriController;
        
        prestitiTable.setItems(listaPrestiti.getPrestiti());
        comboUtente.setItems(listaUtenti.getUtenti());
        comboLibro.setItems(listaLibri.getLibri());
        
        
    }

    @FXML
    private void aggiungiPrestito(ActionEvent event) {
        
        Utente utente = comboUtente.getValue();
        Libro libro = comboLibro.getValue();
        LocalDate data = dataRest.getValue();
        
        // Controllo campi vuoti
        if (utente == null || libro == null || data == null) {
            mostraAlert(Alert.AlertType.WARNING, "Dati mancanti: Seleziona Utente, Libro e Data.");
            return;
        }
        
        Prestito prestito = new Prestito(utente, libro, data);
        ValidaDatiPrestito validatorePrestito = new ValidaDatiPrestito();
        
        if(validatorePrestito.isValido(prestito)){
            //Successo
            listaPrestiti.registraPrestito(prestito);           // aggiungo il prestito nella sua lista
            
            // Aggiornamento la tabella prestiti
            prestitiTable.refresh();                            // Aggiorna la vista della tabella
            // Aggiorna la tabella dei libri nell'altra schermata
            if (libriController != null) {
                libriController.refreshTable();
            }
            
            comboUtente.getSelectionModel().clearSelection();   // Pulisce i campi
            comboLibro.getSelectionModel().clearSelection();
            dataRest.setValue(null);
            
            mostraAlert(Alert.AlertType.INFORMATION, "Prestito registrato con successo!");
            
        }else{
            if (!validatorePrestito.verificaDisponibilitaCopie(libro.getNumCopie())) {
                mostraAlert(Alert.AlertType.ERROR, "Copie del libro esaurite! Impossibile registrare.");
            } 
            else if (!validatorePrestito.verificaLimitePrestito(utente.getPrestitiAttivi())) {
                mostraAlert(Alert.AlertType.ERROR, "L'utente ha raggiunto il limite massimo di 3 prestiti attivi.");
            } 
            else {
                mostraAlert(Alert.AlertType.ERROR, "I dati del prestito non sono validi.");
            }
        }
        
    }


    //Configura la colonna con le CheckBox per gestire la restituzione.
    private void spuntaRestituzione() {
        
    restituzioneClm.setCellValueFactory(cellData -> 
        new SimpleBooleanProperty(!cellData.getValue().getAttivo())
    );
    
    restituzioneClm.setCellFactory(column -> new TableCell<Prestito, Boolean>() {
        private final CheckBox checkBox = new CheckBox();
        
        {
            checkBox.setOnAction(e -> {
                Prestito prestito = getTableView().getItems().get(getIndex());
                
                if (prestito != null && checkBox.isSelected()) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confermi la restituzione del libro?", ButtonType.OK, ButtonType.CANCEL);
                    alert.setTitle("Conferma Restituzione");
                    
                    if (alert.showAndWait().filter(btn -> btn == ButtonType.OK).isPresent()) {
                        listaPrestiti.registraRestituzione(prestito);
                        checkBox.setDisable(true);
                        prestitiTable.refresh();
                        if (libriController != null) libriController.refreshTable();
                        mostraAlert(Alert.AlertType.INFORMATION, "Libro restituito con successo.");
                    } else {
                        checkBox.setSelected(false);
                    }
                }
            });
        }
        
        @Override
        protected void updateItem(Boolean restituito, boolean empty) {
            super.updateItem(restituito, empty);
            if (empty || restituito == null) {
                setGraphic(null);
            } else {
                checkBox.setSelected(restituito);
                checkBox.setDisable(restituito);
                setGraphic(checkBox);
            }
        }
    });
}






    //Configura lo stile delle righe per colorarle di rosso se in ritardo.
    private void checkRitardo() {
        prestitiTable.setRowFactory(tr -> new TableRow<Prestito>() {
            @Override
            protected void updateItem(Prestito prestito, boolean empty) {
                super.updateItem(prestito, empty);
                
                // Pulisce lo stile precedente
                setStyle("");

                if (prestito != null && prestito.getAttivo() && prestito.isRitardo()) {
                    // Colora la riga di rosso se è in ritardo
                    setStyle("-fx-background-color: #ffcccc;");
                }
            }
        });
    }
    
    
    private void mostraAlert(Alert.AlertType type, String messaggio) {
        Alert alert = new Alert(type);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }
}
