package org.example.test;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @DESCRIPTION
 * @CREATE 2021-12-16 8:09 下午
 **/
public class Login extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private String relName = "zhangsan" ;
    private String relPwd = "123" ;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setTitle("登录窗口");
        primaryStage.setResizable(false);

        GridPane gr = new GridPane() ;
        gr.setStyle("-fx-background-color: #a1b1de");
        Scene scene = new Scene(gr);
        primaryStage.setScene(scene);

        Label label_name = new Label("用户名:");
        Label label_pwd = new Label("密码:");

         TextField text_name = new TextField() ;
        text_name.setTooltip(new Tooltip("输入用户名"));
         PasswordField text_pwd = new PasswordField() ;
        text_pwd.setTooltip(new Tooltip("请输入密码"));

        gr.setAlignment(Pos.CENTER);
        gr.add(label_name,0,0);
        gr.add(label_pwd,0,1);
        gr.add(text_name,1,0);
        gr.add(text_pwd,1,1);

        Button cancel = new Button("取消");
        Button login = new Button("登录");

        gr.add(cancel,0,2);
        gr.add(login,1,2);

        gr.setVgap(20);
        gr.setHgap(20);
        GridPane.setMargin(login,new Insets(0,0,0,120));


        primaryStage.show();


        cancel.setOnAction( (ActionEvent event)-> {
                System.out.println("取消按钮");
                text_name.setText("");
                text_pwd.setText("");
            }
        );

        login.setOnAction((ActionEvent event)-> {
            System.out.println("确认按钮");
            String text_nameText = text_name.getText();
            String text_pwdText = text_pwd.getText();
            if(relName.equals(text_nameText) && relPwd.equals(text_pwdText)){
                //成功
                new SuccessWindows() ;
                primaryStage.close();
            }else {
                primaryStage.setTitle("密码输入错误");
                //失败
                FadeTransition fadeTransition = new FadeTransition() ;
                fadeTransition.setDuration(Duration.seconds(0.1));
                fadeTransition.setNode(gr);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();

            }

        });


    }
}


class SuccessWindows {

    private Stage stage = new Stage() ;

    public SuccessWindows() {
        stage.setTitle("登录成功");
        stage.setWidth(200);
        stage.setHeight(200);
        stage.show();

    }
}