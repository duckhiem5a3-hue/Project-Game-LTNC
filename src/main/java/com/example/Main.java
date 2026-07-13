package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Lấy đường dẫn của file ảnh
        // Cách gọi này tìm file ngang hàng với class App hiện tại (tức là com/example/)
        URL imageUrl = getClass().getResource("test.png"); 

        if (imageUrl == null) {
            System.out.println("LỖI: Không tìm thấy file ảnh! Hãy kiểm tra lại tên file hoặc thư mục.");
            return;
        }

        // 2. Tạo đối tượng Image và ImageView để hiển thị
        Image image = new Image(imageUrl.toString());
        ImageView imageView = new ImageView(image);

        // 3. Đưa ảnh vào layout và hiển thị
        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("Test Load Tài Nguyên JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}