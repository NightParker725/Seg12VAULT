package com.example.seg12.model;

import com.example.seg12.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VaultController implements Initializable {

    @FXML
    private Button changeBTN;

    @FXML
    private Button closeBTN;

    @FXML
    private TextArea contentTA;
    @FXML
    void cambiarContraseña(ActionEvent event) {
        HelloApplication.openWindow("password.fxml");
    }

    @FXML
    void cerrarCaja(ActionEvent event) throws IOException {

        String content = contentTA.getText();
        HelloApplication.v.getContent().clear();
        HelloApplication.v.getContent().add(
                new Vault(content)
        );
        HelloApplication.v.save();
        Stage stage = (Stage) this.closeBTN.getScene().getWindow();
        stage.close();
        HelloApplication.openWindow("hello-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FileReader fr = new FileReader("data/data.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                contentTA.setText(contentTA.getText() + linea + "\n");
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }

    }
}
