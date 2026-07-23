package com.nhom27.skyforce.ui.buttons;

import com.nhom27.skyforce.utils.AssetManager;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CustomButton extends Button {
    private Label textLabel;
    private ImageView buttonImageView;

    public CustomButton(String text, String nameImage, Runnable action) {
        this(text, 333, 58, nameImage, action);
    }

    private void setupButtonStyle() {
        this.setBackground(Background.EMPTY); // Bỏ nền xám mặc định
        this.setPadding(Insets.EMPTY); // Bỏ viền lề mặc định
        this.setCursor(Cursor.HAND); // Đổi con trỏ chuột thành bàn tay khi hover
    }

    public CustomButton(Integer width, Integer height, String nameImage, Runnable action) {
        setupButtonStyle();
        Image buttonImage = AssetManager.getImage(nameImage);
        buttonImageView = new ImageView(buttonImage);

        buttonImageView.setFitWidth(width);
        buttonImageView.setFitHeight(height);
        buttonImageView.setPreserveRatio(false); // Ảnh co dãn kích bằng với kích thước

        StackPane graphicContainer = new StackPane();
        graphicContainer.getChildren().addAll(buttonImageView);
        this.setGraphic(graphicContainer);

        this.setOnAction(event -> {
            if (action != null) {
                action.run();
            }
        });
    }

    public CustomButton(String text, Integer width, Integer height, String nameImage, Runnable action) {
        setupButtonStyle();
        Image buttonImage = AssetManager.getImage(nameImage);
        buttonImageView = new ImageView(buttonImage);

        buttonImageView.setFitWidth(width);
        buttonImageView.setFitHeight(height);
        buttonImageView.setPreserveRatio(false); // Ảnh co dãn kích bằng với kích thước

        textLabel = new Label(text);
        textLabel.setTextFill(Color.BLACK);
        Font customFont = AssetManager.getFont("font_kenvector_future_thin", 24);
        textLabel.setFont(customFont);

        StackPane graphicContainer = new StackPane();
        graphicContainer.getChildren().addAll(buttonImageView, textLabel);
        this.setGraphic(graphicContainer);

        this.setOnAction(event -> {
            if (action != null) {
                action.run();
            }
        });
    }

    public void updateLabel(String newText) {
        textLabel.setText(newText);
    }
}