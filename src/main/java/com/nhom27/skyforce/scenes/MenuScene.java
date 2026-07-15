package com.nhom27.skyforce.scenes;

import java.net.URL;

import com.nhom27.skyforce.ui.buttons.CustomButton;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuScene {
    private Scene scene; // Lưu trữ bản 2D

    public MenuScene() {
        createMenuScene();
    }

    private void createMenuScene() {
        // Tạo một "tường" để có thể xếp các khung ảnh, nút lên
        StackPane root = new StackPane();
        String imagePath = "/com/nhom27/skyforce/textures/menu/background.png";
        URL imageUrl = getClass().getResource(imagePath);

        // Tạo khung ảnh
        ImageView bgImageView = null;

        if (imageUrl != null) {
            // Tải ảnh vào bộ nhớ
            Image bgImage = new Image(imageUrl.toString());
            // Đóng khung ảnh
            bgImageView = new ImageView(bgImage);
            bgImageView.setFitWidth(com.nhom27.skyforce.main.Main.WIDTH);
            bgImageView.setFitHeight(com.nhom27.skyforce.main.Main.HEIGHT);
        } else {
            System.out.println("Lỗi: Không tìm thấy ảnh nền menu " + imagePath);
            root.setStyle("-fx-background-color: black;");
        }

        // Tạo giá đỡ dọc cách nhau 20px để hiển thị các nút
        VBox menuBox = new VBox(20);
        // Căn giữa màn hình
        menuBox.setAlignment(Pos.CENTER);

        CustomButton btnPlay = new CustomButton("Chơi Game", () -> {

        });
        CustomButton btnOptions = new CustomButton("Cài Đặt", () -> {

        });
        CustomButton btnExit = new CustomButton("Thoát", () -> {
            System.exit(0);
        });

        // Đặt nút bấm lên giá đỡ
        menuBox.getChildren().addAll(btnPlay, btnOptions, btnExit);

        // Gắn khung ảnh, các nút lên "tường"
        if (bgImageView != null) {
            root.getChildren().addAll(bgImageView, menuBox);
        } else {
            root.getChildren().add(menuBox);
        }
        // Đóng gói "tường" thành "gói 2D"
        scene = new Scene(root, com.nhom27.skyforce.main.Main.WIDTH, com.nhom27.skyforce.main.Main.HEIGHT);
    }

    public Scene getScene() {
        return scene;
    }
}
