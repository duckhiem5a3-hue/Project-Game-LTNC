package com.nhom27.skyforce.scenes;

import javafx.stage.Stage;

public class SceneManager {

    // Đảm bảo được khởi tạo 1 lần duy nhất
    private static SceneManager instance;

    private Stage primaryStage;

    private SceneManager() {
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void switchToMenu() {
        MenuScene menuScene = new MenuScene();
        primaryStage.setScene(menuScene.getScene());

    }

}
