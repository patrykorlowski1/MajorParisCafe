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

    Image cafe1 = new Image(getClass().getResourceAsStream("images/kawa1.png"));
    Image cafe2 = new Image(getClass().getResourceAsStream("images/kawa2.png"));
    Image cafe3 = new Image(getClass().getResourceAsStream("images/kawa3.png"));

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
        cafe.setStyle("-fx-background-image: url('images/kawa1.png');");
        cafe.setStyle("-fx-opacity: 1;");

        new Thread(() ->
        {
            try
            {
                for(int i=0, n=1; i<100; i++)
                {
                    n++;
                    if(n>3) n=1;
                    //tu ma sie przelaczac obrazek
                    //Thread.sleep(1000);
                    //if(n==1) cafe.setStyle("-fx-background-image: url('images/kawa1.png');");
                    //else if(n==2) cafe.setStyle("-fx-background-image: url('images/kawa2.png');");
                    //else if(n==3) cafe.setStyle("-fx-background-image: url('images/kawa3.png');");
                    //Thread.sleep(5000);
                }
                Thread.sleep(5000);
                cafe.setStyle("-fx-opacity: 0;");
                Thread.currentThread().interrupt();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();
        //for(int i=0, n=1; i<1000000000; i++, n++){
            //if(n>3) n=1;
            //cafe.setStyle("-fx-background-image: url('images/kawa"+ n +".png');");
        //}

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
