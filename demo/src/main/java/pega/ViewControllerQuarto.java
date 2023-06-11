package pega;
import java.io.IOException;

import Exceptions.QuartoException;
import Quarto.Quarto;
import Quarto.SistemaDeQuartos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewControllerQuarto {
    @FXML
    private Button btVoltarlogin;
     @FXML
    private Button chequeDisponibilidade;
    @FXML
    private TextField tipoCama;
    @FXML
    private Button registrarClient;
    @FXML 
    private Label Chave;

    private static boolean tipoDaCama;

    private static int chave;
    
    @FXML
    public void onBtchequeDisponibilidade() {
        try{
            String tipoCamaStr = tipoCama.getText();
            tipoCamaStr = tipoCamaStr.toLowerCase();
            Quarto modelo;

            if(tipoCamaStr.equals("casal")){
                modelo = new Quarto(true);
                setTipoDaCama(true);
            }
            else if(tipoCamaStr.equals("solteiro")){
                modelo = new Quarto(false);
                setTipoDaCama(false);
            }
            else{
                throw new QuartoException("Tipo de cama inválido, digite casal ou solteiro !");
            }

            int tipoCamaNum = SistemaDeQuartos.buscarQuarto(modelo);

            if (tipoCamaNum != -1 && tipoCamaNum != -2) {
                //opção de entrada esperada botão aparece
                registrarClient.setVisible(true);
                Chave.setText(String.valueOf(tipoCamaNum));
                setChave(tipoCamaNum);
            } 
            else if(tipoCamaNum == -1){
                throw new QuartoException("Não temos quartos do tipo escolhido disponível no momento !");
            }
            else{
                throw new QuartoException("Quarto não encontrado !");
            }
        }
        catch(Exception e){
            ThrowAlerta.exibirAlertaErro("ERRO", e.getMessage());
        }
    }
    @FXML
    private void onBtregistrarClient() throws IOException{
        //mudança de tela para completar preenchimento de dados
        App.setRoot("viewaddcliente");
        
    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.setRoot("viewcliente");

    }
    
    public static void setTipoDaCama(boolean tipo){
        tipoDaCama = tipo;
    }

    public static void setChave(int chaveAtual){
        chave = chaveAtual;
    }

    public static boolean getTipoDaCama(){
        return tipoDaCama;
    }

    public static int getChave(){
        return chave;
    }

}
