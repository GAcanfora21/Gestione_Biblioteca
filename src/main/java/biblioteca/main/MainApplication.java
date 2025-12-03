package biblioteca.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Giuseppe
 */
public class MainApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Loader recupera la struttura grafica dal nostro file FXML
        Parent root = FXMLLoader.load(getClass().getResource("GestioneBibliotecaView.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Gestione Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}