package com.nhom27.skyforce.scenes;

<<<<<<< HEAD
import com.nhom27.skyforce.audio.AudioManager;
=======
import java.net.URL;

import com.nhom27.skyforce.Entitiy.GameObject;
>>>>>>> 12f81257fb80164f2be7e6ed3f17d5f86b891f99
import com.nhom27.skyforce.ui.buttons.CustomButton;
import com.nhom27.skyforce.utils.AssetManager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuScene {
    private Scene scene; // Lưu trữ bản 2D
    private CustomButton btnSound;

    public MenuScene() {
        createMenuScene();
    }

    private void createMenuScene() {

        //thử tạo gameobject
        
        //GameObject plane = new GameObject();
        
       
    
        // Tạo một "tường" để có thể xếp các khung ảnh, nút lên
        StackPane root = new StackPane();
        // Tải ảnh vào bộ nhớ
        Image bgImage = AssetManager.getImage("background_home");
        // Tạo khung ảnh
        ImageView bgImageView = null;

        if (bgImage != null) {
            // Đóng khung ảnh
            bgImageView = new ImageView(bgImage);
            bgImageView.setFitWidth(com.nhom27.skyforce.main.Main.WIDTH);
            bgImageView.setFitHeight(com.nhom27.skyforce.main.Main.HEIGHT);
        } else {
            System.out.println("Lỗi: Không tìm thấy ảnh nền menu!");
            root.setStyle("-fx-background-color: black;");
        }

        // Tạo giá đỡ dọc cách nhau 20px để hiển thị các nút
        VBox menuBox = new VBox(20);
        // Căn giữa màn hình
        menuBox.setAlignment(Pos.CENTER);

        CustomButton btnPlay = new CustomButton("Chơi Game", () -> {

        });
        btnSound = new CustomButton("Nhạc Nền: Bật", () -> {
            AudioManager.getInstance().toggleMute();
            if (AudioManager.getInstance().isMuted()) {
                btnSound.updateLabel("Nhạc Nền: Tắt");
            } else {
                btnSound.updateLabel("Nhạc Nền: Bật");
            }
        });
        CustomButton btnExit = new CustomButton("Thoát", () -> {
            System.exit(0);
        });

        // Đặt nút bấm lên giá đỡ
        menuBox.getChildren().addAll(btnPlay, btnSound, btnExit);

        // Gắn khung ảnh, các nút lên "tường"
        
        if (bgImageView != null) {
            root.getChildren().addAll(bgImageView, menuBox);
        } else {
            root.getChildren().add(menuBox);
        }
        
        //root.getChildren().add(plane.getView());

        // Đóng gói "tường" thành "gói 2D"
        scene = new Scene(root, com.nhom27.skyforce.main.Main.WIDTH, com.nhom27.skyforce.main.Main.HEIGHT);
    }

    public Scene getScene() {
        return scene;
    }
}
