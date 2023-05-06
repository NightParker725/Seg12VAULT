package com.example.seg12.model;

import com.example.seg12.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordController {

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
    private PasswordField GPF;

    @FXML
    private PasswordField HPF;

    @FXML
    private PasswordField IPF;

    @FXML
    private PasswordField JPF;

    @FXML
    private PasswordField KPF;

    @FXML
    private PasswordField LPF;

    @FXML
    private Button changeBTN;

    @FXML
    private Button closeBTN;

    @FXML
    void changePass(ActionEvent event) throws IOException {
        String c = APF.getText();
        String o = BPF.getText();
        String n = CPF.getText();
        String t = DPF.getText();
        String r = EPF.getText();
        String a = FPF.getText();
        String key = c + o + n + t + r + a;
        if (key.equals(HelloApplication.v.getPassword())){
            String p = GPF.getText();
            String s = HPF.getText();
            String S = IPF.getText();
            String w = JPF.getText();
            String R = KPF.getText();
            String d = LPF.getText();
            String pass = p + s + S + w + R + d;
            HelloApplication.v.setPassword(pass);
            HelloApplication.v.savePassword();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exito");
            alert.setContentText("La contraseña ha sido actualizada");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("La contraseña ingresada es invalida");
            alert.showAndWait();
        }

    }

    @FXML
    void closeVault(ActionEvent event) {
        Stage stage = (Stage) this.closeBTN.getScene().getWindow();
        stage.close();
    }

}
