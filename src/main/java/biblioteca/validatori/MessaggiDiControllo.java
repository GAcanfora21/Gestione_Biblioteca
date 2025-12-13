/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.validatori;

import javafx.scene.control.Alert;

/**
 *
 * @author Giuseppe
 */
public class MessaggiDiControllo {
    
        public static void mostraAlert(Alert.AlertType type, String messaggio) {
            Alert alert = new Alert(type);
            alert.setContentText(messaggio);
            alert.showAndWait();
        }
}
