package sample;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ToggleButton late;

    @FXML
    public ToggleButton espresso;

    @FXML
    public Button start;
    public Button sugar1;
    public Button sugar2;
    public Button sugar3;
    public Button sugar4;
    public Button sugar5;
    public Button sugar6;

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
    public void refillAccessories(ActionEvent event){
        sugar1.setStyle("-fx-opacity: 1;");
        sugar2.setStyle("-fx-opacity: 1;");
        sugar3.setStyle("-fx-opacity: 1;");
        sugar4.setStyle("-fx-opacity: 1;");
        sugar5.setStyle("-fx-opacity: 1;");
        sugar6.setStyle("-fx-opacity: 1;");
    }

    @FXML
    public void startCafeHandler(ActionEvent event) {
        if(late.isSelected() || espresso.isSelected()){
            cafe.setStyle("-fx-background-image: url('images/kawa1.png');");
            cafe.setStyle("-fx-opacity: 1;");

            if(late.isSelected()) start.setText("Caffe latte");
            if(espresso.isSelected()) start.setText("Espresso");

            Media cafeAudio = new Media(this.getClass().getResource("images/cafe_audio.mp3").toString());
            MediaPlayer cafeAudioPlayer = new MediaPlayer(cafeAudio);
            cafeAudioPlayer.play();

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
                    toggleButtons();
                    Platform.runLater(()->{
                        start.setText("START");
                    });
                    Thread.currentThread().interrupt();

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }).start();
        }


    }

    @FXML
    public void pickUpOrder(ActionEvent event) {
            takenCup.setStyle("-fx-opacity: 0;");
    }

    @FXML
    public void takeSugar(ActionEvent event){
        ((Button)event.getSource()).setStyle("-fx-opacity: 0;");
    }

    public void toggleButtons() {
        espresso.setSelected(false);
        late.setSelected(false);

    }
}
