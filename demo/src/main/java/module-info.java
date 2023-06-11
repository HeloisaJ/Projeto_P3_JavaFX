module pega {
    requires javafx.controls;
    requires javafx.fxml;

    opens pega to javafx.fxml;
    exports pega;
    opens Funcionario to javafx.base;
}
