/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.validatori;

import javafx.scene.control.Alert;

/**
 * @brief Classe che permette all'utente di visualizzare un messaggio
 * 
 * La classe permette di creare un pop-up di avviso, errore o informazione all'interno dell'applicazione JavaFX.
 * 
 * @author Giuseppe
 * @date December 15, 2025
 * @version 1.0
 */
public class MessaggiDiControllo {
    
        /**
         * @brief Mostra una finestra di dialogo a schermo
         * 
         * @param[in] type Il tipo di avviso (es. AllertType.ERROR, mostra un pop-up di errore)
         * @param[in] messaggio Il messaggio da visualizzare nella finestra di dialogo 
         */
        public static void mostraAlert(Alert.AlertType type, String messaggio) {
            Alert alert = new Alert(type);
            alert.setContentText(messaggio);
            alert.showAndWait();
        }
}
