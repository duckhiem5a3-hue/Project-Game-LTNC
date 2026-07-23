package com.nhom27.skyforce.scenes;

import com.nhom27.skyforce.audio.AudioManager;
import com.nhom27.skyforce.ui.buttons.CustomButton;
import com.nhom27.skyforce.utils.AssetManager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

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
        CustomButton btnPause = new CustomButton(50, 50, "button_pause_blue", () -> {
            showPauseMenu(true);
        });
        StackPane.setAlignment(btnPause, Pos.TOP_LEFT);
        StackPane.setMargin(btnPause, new Insets(15, 0, 0, 10));
        root.getChildren().add(btnPause);

        // Tạo Pause Overlay Menu
        createPauseOverlay(root);

        scene = new Scene(root, com.nhom27.skyforce.main.Main.WIDTH, com.nhom27.skyforce.main.Main.HEIGHT);
    }

    private void createPauseOverlay(StackPane root) {
        pauseOverlay = new StackPane();
        // Tạo lớp nền mờ, không bo góc, không thụt lề (đảm bảo che phủ màn hình chơi)
        pauseOverlay.setBackground(
                new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.65), CornerRadii.EMPTY, Insets.EMPTY)));
        pauseOverlay.setVisible(false); // Ban đầu ẩn menu

        VBox card = new VBox(18);
        card.setAlignment(Pos.CENTER);
        card.setMaxSize(360, 420);
        // card.setPadding(new Insets(30, 40, 30, 40));

        // Nền xanh đậm cho card
        LinearGradient cardGradient = new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#1e2c3a")),
                new Stop(1, Color.web("#121b24")));
        CornerRadii radii16 = new CornerRadii(16); // Bo góc cho card
        card.setBackground(new Background(new BackgroundFill(cardGradient, radii16, Insets.EMPTY)));

        // Viền cho Card
        card.setBorder(new Border(new BorderStroke(
                Color.rgb(120, 210, 255, 0.3),
                BorderStrokeStyle.SOLID, // nét liền
                radii16,
                new BorderWidths(2)))); // độ dày của viền

        // Đổ bóng cho Card
        card.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.8), 20, 0.5, 0, 4));

        Label titleLabel = new Label("Game Paused");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(AssetManager.getFont("font_kenvector_future", 28));
        titleLabel.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(77, 141, 182, 0.8), 10, 0.5, 0, 0));

        // 1. Nút Tiếp tục (Resume)
        CustomButton btnResume = new CustomButton("Resume", "button_blue", () -> {
            showPauseMenu(false);
        });

        // 2. Nút Chơi lại (Restart)
        CustomButton btnRestart = new CustomButton("PLAY AGAIN", "button_blue", () -> {
            PlayScene newPlayScene = new PlayScene();
            SceneManager.getInstance().switchScene(newPlayScene.getScene());
        });

        // 3. Nút Âm thanh (Sound Toggle)
        String soundStatus = AudioManager.getInstance().isMuted() ? "Music: Off" : "Music: On";
        btnSound = new CustomButton(soundStatus, "button_blue", () -> {
            AudioManager.getInstance().toggleMute();
            if (AudioManager.getInstance().isMuted()) {
                btnSound.updateLabel("Music: Off");
            } else {
                btnSound.updateLabel("Music: On");
            }
        });

        // 4. Nút Về Trang Chủ (Main Menu)
        CustomButton btnMainMenu = new CustomButton("Home", "button_blue", () -> {
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
