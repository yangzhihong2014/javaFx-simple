package org.example.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @DESCRIPTION
 * @CREATE 2021-12-29 12:14 下午
 **/
public class IncreasingBtn extends Application {
    public static void main( String[] args )
    {
        launch(args);

    }
    int i = 0 ;
    @Override
    public void start(Stage primaryStage) throws Exception {

//        HostServices hostServices = getHostServices();
//        hostServices.showDocument("https://www.bilibili.com/video/BV1KW411z7Pa");



        Button button = new Button("按钮") ;


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button bb = (Button) event.getSource();
                System.out.println(bb.getText());
                i++ ;
                bb.setText("按钮："+i);

            }
        });

        Group group = new Group() ;
        group.getChildren().add(button);

        Scene scene = new Scene(group) ;


        primaryStage.setScene(scene);
        primaryStage.setTitle("java  fx");
        primaryStage.setWidth( 500);
        primaryStage.setHeight( 500);

        primaryStage.setResizable(false);
        primaryStage.show();




    }
}
