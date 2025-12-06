/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.view.controller;

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
    private TextField libriTFD;
    @FXML
    private Button cercaLibro;
    @FXML
    private Button eliminaLibro;
    @FXML
    private TextField titoloTFD;
    @FXML
    private TextField autoriTFD;
    @FXML
    private TextField annoTFD;
    @FXML
    private TextField codiceTFD;
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
    private TextField libriTFD1;
    @FXML
    private Button cercaUtente;
    @FXML
    private Button eliminaUtente;
    @FXML
    private TextField nomeTFD;
    @FXML
    private TextField cognomeTFD;
    @FXML
    private TextField emailTFD;
    @FXML
    private TextField matricolaTFD;
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
    private Button eliminaPrestito;
    @FXML
    private TextField dataResoTFD;
    @FXML
    private TextField utentePTFD;
    @FXML
    private TextField libroPTFD;

    @FXML
    private void goToLibri(ActionEvent event) {
    }

    @FXML
    private void goToUtenti(ActionEvent event) {
    }

    @FXML
    private void goToPrestiti(ActionEvent event) {
    }
    
}
