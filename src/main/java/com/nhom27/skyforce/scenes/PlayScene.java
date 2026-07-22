package com.nhom27.skyforce.scenes;

import com.nhom27.skyforce.audio.AudioManager;
import com.nhom27.skyforce.ui.buttons.CustomButton;
import com.nhom27.skyforce.utils.AssetManager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PlayScene {
    private Scene scene;
    private StackPane pauseOverlay;
    private CustomButton btnSound;

    public PlayScene() {
        StackPane root = new StackPane();
        Image bgImage = AssetManager.getImage("background_play");
        ImageView bgImageView = null;

        if (bgImage != null) {
            bgImageView = new ImageView(bgImage);
            bgImageView.setFitWidth(com.nhom27.skyforce.main.Main.WIDTH);
            bgImageView.setFitHeight(com.nhom27.skyforce.main.Main.HEIGHT);
        } else {
            System.out.println("Lỗi: Không tìm thấy ảnh nền play!");
            root.setStyle("-fx-background-color: black;");
        }

        if (bgImageView != null) {
            root.getChildren().add(bgImageView);
        }

        // Tạo Nút Pause ở góc trên trái
        CustomButton btnPause = new CustomButton("Pause", () -> {
            showPauseMenu(true);
        });
        btnPause.getStyleClass().add("pause-button");
        StackPane.setAlignment(btnPause, Pos.TOP_LEFT);
        StackPane.setMargin(btnPause, new Insets(15, 0, 0, 10));
        root.getChildren().add(btnPause);

        // Tạo Pause Overlay Menu
        createPauseOverlay(root);

        scene = new Scene(root, com.nhom27.skyforce.main.Main.WIDTH, com.nhom27.skyforce.main.Main.HEIGHT);
        String css = AssetManager.getCss("styleButton");
        if (css != null) {
            scene.getStylesheets().add(css);
        }
    }

    private void createPauseOverlay(StackPane root) {
        pauseOverlay = new StackPane();
        pauseOverlay.getStyleClass().add("pause-overlay");
        pauseOverlay.setVisible(false); // Ban đầu ẩn menu

        VBox card = new VBox(18);
        card.setAlignment(Pos.CENTER);
        card.getStyleClass().add("pause-menu-card");
        card.setMaxSize(360, 420);

        Label titleLabel = new Label("TẠM DỪNG");
        titleLabel.getStyleClass().add("pause-title");

        // 1. Nút Tiếp tục (Resume)
        CustomButton btnResume = new CustomButton("Tiếp tục", () -> {
            showPauseMenu(false);
        });

        // 2. Nút Chơi lại (Restart)
        CustomButton btnRestart = new CustomButton("Chơi lại", () -> {
            PlayScene newPlayScene = new PlayScene();
            SceneManager.getInstance().switchScene(newPlayScene.getScene());
        });

        // 3. Nút Âm thanh (Sound Toggle)
        String soundStatus = AudioManager.getInstance().isMuted() ? "Nhạc Nền: Tắt" : "Nhạc Nền: Bật";
        btnSound = new CustomButton(soundStatus, () -> {
            AudioManager.getInstance().toggleMute();
            if (AudioManager.getInstance().isMuted()) {
                btnSound.updateLabel("Nhạc Nền: Tắt");
            } else {
                btnSound.updateLabel("Nhạc Nền: Bật");
            }
        });

        // 4. Nút Về Trang Chủ (Main Menu)
        CustomButton btnMainMenu = new CustomButton("Trang Chủ", () -> {
            SceneManager.getInstance().switchScene("MenuScene");
        });

        card.getChildren().addAll(titleLabel, btnResume, btnRestart, btnSound, btnMainMenu);
        pauseOverlay.getChildren().add(card);

        root.getChildren().add(pauseOverlay);
    }

    private void showPauseMenu(boolean show) {
        pauseOverlay.setVisible(show);
        if (show) {
            pauseOverlay.toFront();
        }
    }

    public Scene getScene() {
        return scene;
    }
}
