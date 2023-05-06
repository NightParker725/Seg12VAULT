package com.example.seg12.model;

import com.example.seg12.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private PasswordField APF;

    @FXML
    private PasswordField BPF;

    @FXML
    private PasswordField CPF;

    @FXML
    private PasswordField DPF;

    @FXML
    private PasswordField EPF;

    @FXML
    private PasswordField FPF;

    @FXML
    private Button openBTN;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            HelloApplication.v.loadPassword();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

     @FXML
    public void open(ActionEvent actionEvent) {
         String c = APF.getText();
         String o = BPF.getText();
         String n = CPF.getText();
         String t = DPF.getText();
         String r = EPF.getText();
         String a = FPF.getText();
         String key = c + o + n + t + r + a;
         if (key.equals(HelloApplication.v.getPassword())){
             Stage stage = (Stage) this.openBTN.getScene().getWindow();
             stage.close();
             HelloApplication.openWindow("vault.fxml");
         }else {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Error");
             alert.setContentText("La contraseña ingresada es invalida");
             alert.showAndWait();
         }
    }
}
