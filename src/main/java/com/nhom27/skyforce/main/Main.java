package com.nhom27.skyforce.main;

import com.nhom27.skyforce.scenes.SceneManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    // Kích thước của cửa sổ game
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;

    @Override
    public void start(Stage primaryStage) {
        // Đưa "gói 2D" lên cửa sổ hiển thị trò chơi
        primaryStage.setTitle("Sky Force - Nhóm 27");

        // Giao cửa sổ cho SceneManager quản lý
        SceneManager.getInstance().setPrimaryStage(primaryStage);

        // Bật Menu trang chủ
        SceneManager.getInstance().switchToMenu();

        // Không cho người dùng thay đổi kích thước cửa sổ
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}