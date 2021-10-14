package com.tp_java;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
// import javafx.stage.Window;

public class Interfaces extends Application
{

    private int nbrOfCliks = 0;

    private Stage mainWindow = null;
    private Stage confirmationStage = null;
    private Scene mainScene = null;


    public static void main( String[] args )
    {
        launch(args);
    }

    
    @Override
    public void start(Stage mainWindow) throws Exception {
        // TODO Auto-generated method stub

        this.mainWindow = mainWindow;
        
        Button b = new Button("Click");
        Label l = new Label("Hello");


        b.setOnMouseClicked(e -> {
            nbrOfCliks++;
            l.setText("Clicked : " + nbrOfCliks);

            Scene confirmationScene = createdConfirmationView();
            confirmationStage = new Stage();
            confirmationStage.setTitle("confirmation");
            confirmationStage.setScene(confirmationScene);
            confirmationStage.initModality(Modality.APPLICATION_MODAL);

            if(nbrOfCliks == 10) {
                // mainWindow.setScene(confirmationScene);
                confirmationStage.show();
                nbrOfCliks = 0;
            }
        });
            
        
        VBox box1 = new VBox();
        box1.getChildren().addAll(l,b);
        box1.setAlignment(Pos.CENTER); //pour centrer
        box1.setSpacing(20);
 
        Scene mainScene = new Scene(box1, 300, 200);
        this.mainScene = mainScene;

        mainWindow.setTitle("My window");
        mainWindow.setScene(mainScene);

        mainWindow.show();
    }

    public Scene createdConfirmationView() {
        Label l = new Label("You clicked 10 times, do you want to quit ?");
        Button yes = new Button("Yes");
        Button no = new Button("No");
        HBox box2 = new HBox();
        box2.getChildren().addAll(yes,no);
        box2.setAlignment(Pos.CENTER);
        box2.setSpacing(40);
        VBox box1 = new VBox();
        box1.getChildren().addAll(l, box2);
        box1.setAlignment(Pos.CENTER);
        box1.setSpacing(40);  
        
        yes.setOnMouseClicked(e -> {
            this.mainWindow.close();
            this.confirmationStage.close();
        });

        no.setOnMouseClicked(e -> {
            this.confirmationStage.close();
        });

        return new Scene(box1, 200, 100);
    }
}
