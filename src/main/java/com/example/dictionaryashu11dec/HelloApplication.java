package com.example.dictionaryashu11dec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    Label meaningLabel;
    Button searchButton;
    TextField wordTextField;

    DictionaryUsingHashMap dictionaryUsingHashMap = new DictionaryUsingHashMap();
    ListView<String > suggestionList;
    Pane createContent(){
        Pane root= new Pane();
        root.setPrefSize(400,250);

        wordTextField = new TextField();
        wordTextField.setTranslateX(20);
        wordTextField.setTranslateY(30);

        searchButton = new Button("Search");
        searchButton.setTranslateX(200);
        searchButton.setTranslateY(30);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
              //  meaningLabel.setText("Button is Clicked");
//                meaningLabel.setTranslateX(20);
//                meaningLabel.setTranslateY(60);

                //wordTextField.getText();
                String word = wordTextField.getText();
                if(word.isBlank() || word.isEmpty()){
                    meaningLabel.setText("Please enter a word ! ");
                    meaningLabel.setTextFill(Color.RED);

                }
                else{
                    String  meaning = dictionaryUsingHashMap.getMeaning( word);
                    meaningLabel.setText("Meaning : " +meaning);
                    meaningLabel.setTextFill(Color.BLUE);
                }
            }
        });


//        searchButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//            }
//        });


        meaningLabel = new Label("");
        meaningLabel.setTranslateX(20);
        meaningLabel.setTranslateY(60);

        suggestionList = new  ListView<>();
        suggestionList.setTranslateX(20);
        suggestionList.setTranslateY(100);
        suggestionList.setMinSize(300,40);
        suggestionList.setMaxSize(350,50);

        String[] wordList= {"Phase" ,"project","start", "shubh","Depreciating assets"};
        suggestionList.getItems().addAll(wordList);
        suggestionList.setOrientation(Orientation.HORIZONTAL);
         suggestionList.setOnMouseClicked(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent mouseEvent) {
                 String selectedWord =suggestionList.getSelectionModel().getSelectedItem();
                 wordTextField.setText(selectedWord);
             }
         });


        root.getChildren().addAll(wordTextField,searchButton,meaningLabel,suggestionList);


        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}