package com.nhom27.skyforce.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class CustomButton extends Button {
    private Label textLabel;

    public CustomButton(String text, Runnable action) {
        this.getStyleClass().add("button");

        Region shadow = new Region();
        shadow.getStyleClass().add("shadow");

        Region edge = new Region();
        edge.getStyleClass().add("edge");

        StackPane front = new StackPane();
        front.getStyleClass().add("front");

        textLabel = new Label(text);
        front.getChildren().add(textLabel);

        StackPane graphicPane = new StackPane();
        graphicPane.getChildren().addAll(shadow, edge, front);

        // Đặt cấu trúc đồ họa cho Button
        this.setGraphic(graphicPane);

        // Áp dụng đồ hoạc CSS cho Button
        String css = this.getClass().getResource("/com/nhom27/skyforce/ui/buttons/styleButton.css")
                .toExternalForm();
        this.getStylesheets().add(css);

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