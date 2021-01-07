package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button cupToTake1;

    @FXML
    private Button cupToTake2;

    @FXML
    private Button takenCup;

    @FXML
    public Pane cafe;

    @FXML
    public void takeCupFromHandler(ActionEvent event) {
        takenCup.setStyle("-fx-opacity: 1;");
    }

    @FXML
    public void startCafeHandler(ActionEvent event) {
        cafe.setStyle("-fx-opacity: 1;");
        //for(int i=0, n=1; i<1000000000; i++, n++){
            //if(n>3) n=1;
            //cafe.setStyle("-fx-background-image: url('images/kawa"+ n +".png');");
        //}
        //cafe.setStyle("-fx-opacity: 0;");

    }

    @FXML
    public void pickUpOrder(ActionEvent event) {
            takenCup.setStyle("-fx-opacity: 0;");
    }

    @FXML
    public void takeSugar(ActionEvent event){
        ((Button)event.getSource()).setStyle("-fx-opacity: 0;");
    }
}
