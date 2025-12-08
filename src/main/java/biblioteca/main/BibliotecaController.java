/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Giuseppe
 */
public class BibliotecaController {

    @FXML
    private Tab tabDashboard;
    @FXML
    private Button buttonLibri;
    @FXML
    private Button buttonUtenti;
    @FXML
    private Button buttonPrestiti;
    @FXML
    private MenuItem salva;
    @FXML
    private MenuItem carica;
    @FXML
    private Tab tabLibri;
    @FXML
    private TableView<?> libri;
    @FXML
    private TableColumn<?, ?> titolo;
    @FXML
    private TableColumn<?, ?> autori;
    @FXML
    private TableColumn<?, ?> annoDiPubblicazione;
    @FXML
    private TableColumn<?, ?> codiceIdentificativo;
    @FXML
    private TableColumn<?, ?> copie;
    @FXML
    private Button aggiungiLibro;
    @FXML
    private Button cercaLibro;
    @FXML
    private Button eliminaLibro;
    @FXML
    private Tab tabUtenti;
    @FXML
    private TableView<?> utenti;
    @FXML
    private TableColumn<?, ?> nome;
    @FXML
    private TableColumn<?, ?> cognome;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> matricola;
    @FXML
    private Button aggiungiUtente;
    @FXML
    private Button cercaUtente;
    @FXML
    private Button eliminaUtente;
    @FXML
    private Tab tabPrestiti;
    @FXML
    private TableView<?> prestiti;
    @FXML
    private TableColumn<?, ?> utenteP;
    @FXML
    private TableColumn<?, ?> libroP;
    @FXML
    private TableColumn<?, ?> dataReso;
    @FXML
    private TableColumn<?, ?> restituzione;
    @FXML
    private Button aggiungiPrestito;
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
    private TextField codiceField1;
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
    private void goToLibri(ActionEvent event) {
    }

    @FXML
    private void goToUtenti(ActionEvent event) {
    }

    @FXML
    private void goToPrestiti(ActionEvent event) {
    }

    @FXML
    private void updateTitolo(TableColumn.CellEditEvent<?, ?> event) {
    }

    @FXML
    private void updateAutori(TableColumn.CellEditEvent<?, ?> event) {
    }

    @FXML
    private void updateAnno(TableColumn.CellEditEvent<?, ?> event) {
    }

    @FXML
    private void updateCodice(TableColumn.CellEditEvent<?, ?> event) {
    }

    @FXML
    private void updateCopie(TableColumn.CellEditEvent<?, ?> event) {
    }

    @FXML
    private void updateNome(TableColumn.CellEditEvent<?, ?> event) {
    }

    @FXML
    private void updateCognome(TableColumn.CellEditEvent<?, ?> event) {
    }

    @FXML
    private void updateEmail(TableColumn.CellEditEvent<?, ?> event) {
    }

    @FXML
    private void updateMatricola(TableColumn.CellEditEvent<?, ?> event) {
    }
    
}
