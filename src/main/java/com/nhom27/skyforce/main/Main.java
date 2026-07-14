package com.nhom27.skyforce.main;

import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    // Kích thước của cửa sổ game
    private final int WIDTH = 1200;
    private final int HEIGHT = 900;

    @Override
    public void start(Stage primaryStage) {

        String imagePath = "/com/nhom27/skyforce/textures/menu/background.png";
        URL imageUrl = getClass().getResource(imagePath);

        // Tạo một "tường" để có thể xếp các khung ảnh, nút lên
        StackPane root = new StackPane();

        if (imageUrl != null) {
            // Tải ảnh vào bộ nhớ
            Image bgImage = new Image(imageUrl.toString());
            // Đóng khung ảnh
            ImageView bgImageView = new ImageView(bgImage);
            bgImageView.setFitWidth(WIDTH);
            bgImageView.setFitHeight(HEIGHT);

            // Gắn khung ảnh lên nền "tường"
            root.getChildren().add(bgImageView);
        } else {
            System.out.println("Lỗi: Không tìm thấy ảnh nền menu " + imagePath);
            root.setStyle("-fx-background-color: black;");
        }

        // Đóng gói "tường" thành "gói 2D"
        Scene gameScene = new Scene(root, WIDTH, HEIGHT);

        // Đưa "gói 2D" lên cửa sổ hiển thị trò chơi
        primaryStage.setTitle("Sky Force - Nhóm 27");
        primaryStage.setScene(gameScene);
        // Không cho người dùng thay đổi kích thước cửa sổ
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}