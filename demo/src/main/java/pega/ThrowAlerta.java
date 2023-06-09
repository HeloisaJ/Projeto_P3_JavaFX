package pega;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ThrowAlerta {
    public static void exibirAlertaErro(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}