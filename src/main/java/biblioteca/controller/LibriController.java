package biblioteca.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import biblioteca.main.GestioneLibri;
import biblioteca.main.GestionePrestiti;
import biblioteca.main.Libro;
import biblioteca.validatori.MessaggiDiControllo;
import biblioteca.validatori.ValidaDatiLibro;
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
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 */
public class LibriController implements Initializable {

    @FXML private TableView<Libro> libriTable;
    @FXML private TableColumn<Libro, String> titoloClm;
    @FXML private TableColumn<Libro, String> autoriClm;
    @FXML private TableColumn<Libro, String> annoDiPubblicazioneClm;
    @FXML private TableColumn<Libro, String> codiceIdentificativoClm;
    @FXML private TableColumn<Libro, Integer> copieClm;

    @FXML private TextField cercaLibriField;
    @FXML private TextField titoloField;
    @FXML private TextField autoriField;
    @FXML private TextField annoField;
    @FXML private TextField copieField;
    @FXML private TextField codiceField;
    @FXML private Button btnAggiungiLibro;
    @FXML private Button btnEliminaLibro;
    @FXML private Button btnCercaLibro;

    private GestioneLibri listaLibri;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Collegamento colonna-parametro di Libri
        titoloClm.setCellValueFactory(new PropertyValueFactory<>("titolo"));
        autoriClm.setCellValueFactory(new PropertyValueFactory<>("autori"));
        annoDiPubblicazioneClm.setCellValueFactory(new PropertyValueFactory<>("annoDiPubblicazione"));
        codiceIdentificativoClm.setCellValueFactory(new PropertyValueFactory<>("codiceIdentificativo"));
        copieClm.setCellValueFactory(new PropertyValueFactory<>("numCopie"));

        // Celle modificabili
        titoloClm.setCellFactory(TextFieldTableCell.forTableColumn());
        autoriClm.setCellFactory(TextFieldTableCell.forTableColumn());
        annoDiPubblicazioneClm.setCellFactory(TextFieldTableCell.forTableColumn());
        codiceIdentificativoClm.setCellFactory(TextFieldTableCell.forTableColumn());
        copieClm.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
        cercaLibro();
    }
    
    public void init(GestioneLibri listaLibri) {
        this.listaLibri = listaLibri;
        libriTable.setItems(listaLibri.getLibri());
    }
    
    // Metodo utilizzato da PrestitiController per aggiornare la sua tabella in seguito ad una registrazione prestito
    public void refreshTable(){
        libriTable.refresh();
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
    
    

   public void cercaLibro() {
        //Gestione del cambiamento della lista libri quando si effettua la ricerca una stringa nel textfield 'cercaLibriField'
        cercaLibriField.textProperty().addListener((observable, vecchioValore, nuovoValore) -> {
            
            if (vecchioValore == null || nuovoValore.trim().isEmpty()) {
                // Ripristina la lista originale completa
                libriTable.setItems(listaLibri.getLibri());
            }else{
                libriTable.setItems(listaLibri.cerca(nuovoValore)); //Mi permette di cercare automaticamente mentre scrivo nel textfield
            }
        });
    }

   
    @FXML
    private void aggiungiLibro(ActionEvent event) {
        
        //Libro da inserire
        Libro libro = new Libro(titoloField.getText(), autoriField.getText(), annoField.getText(),
                codiceField.getText(), copieField.getText().isEmpty() ? 0 : Integer.parseInt(copieField.getText()));
         
        //Controllo validità
        ValidaDatiLibro validatoreLibro = new ValidaDatiLibro(listaLibri.getLibri());
        if(validatoreLibro.isValido(libro)){
        
            listaLibri.aggiungi(libro);
            
            titoloField.clear();
            autoriField.clear();
            annoField.clear();
            copieField.clear();
            codiceField.clear();
        }else if(titoloField.getText().isEmpty() || autoriField.getText().isEmpty() ||
                annoField.getText().isEmpty() || copieField.getText().isEmpty() || codiceField.getText().isEmpty()){
            MessaggiDiControllo.mostraAlert(Alert.AlertType.ERROR, "Inserisci tutti i campi presenti");
        }else{
            MessaggiDiControllo.mostraAlert(Alert.AlertType.ERROR, "Formato codice non valido:\n"
                    + "1) Il formato codice deve avere una lunghezza di 10 caratteri, no caratteri speciali e/o spazi.\n"
                    + "2) Il codice identificativo non deve essere già presente nella lista");      
        }
    }

    @FXML
    private void eliminaLibro(ActionEvent event) {
        
        Libro libro = libriTable.getSelectionModel().getSelectedItem();     // Libro selezionato dalla tabella
        
        // Controllo libro in prestito
        if(libro.getPrestato()){
            MessaggiDiControllo.mostraAlert(Alert.AlertType.ERROR, "Non è possibile cancellare un libro preso in prestito");
            return;
        }
        
        // Successo
        listaLibri.elimina(libro);
        
        String testo = cercaLibriField.getText();
        
        //
        if(testo != null && !testo.isEmpty()){
            libriTable.setItems(listaLibri.cerca(testo));   //forzo il ricalcolo della ricerca sulla lista una volta che l'elemento è stato eliminato
        }
    }


}
