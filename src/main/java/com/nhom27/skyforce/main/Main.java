package com.nhom27.skyforce.main;

import com.nhom27.skyforce.scenes.MenuScene;
import com.nhom27.skyforce.Entitiy.GameObject;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    // Kích thước của cửa sổ game
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;

    @Override
    public void start(Stage primaryStage) {

        

        // Đưa "gói 2D" lên cửa sổ hiển thị trò chơi
        primaryStage.setTitle("Sky Force - Nhóm 27");

        // Tạo Menu
        MenuScene menuScene = new MenuScene(primaryStage);
        primaryStage.setScene(menuScene.getScene());

        // Không cho người dùng thay đổi kích thước cửa sổ
        primaryStage.setResizable(false);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}