module pega {
    requires javafx.controls;
    requires javafx.fxml;

    opens pega to javafx.fxml;
    exports pega;
    opens Funcionario to javafx.base;
    opens Sistema to javafx.base;
    opens TipoPessoa.Cliente;
}
