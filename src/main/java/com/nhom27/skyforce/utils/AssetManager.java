package com.nhom27.skyforce.utils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class AssetManager {
    public static final Map<String, Image> images = new HashMap();

    public static void loadImage(String name, String path) {
        if (!images.containsKey(name)) {
            URL imageUrl = AssetManager.class.getResource(path);
            if (imageUrl != null) {
                Image image = new Image(imageUrl.toString());
                images.put(name, image);
                System.out.println("Tải thành công ảnh: " + name);
            } else {
                System.out.println("Lỗi tải ảnh: " + name);
            }

        }
    }

    public static Image getImage(String name) {
        if (!images.containsKey(name)) {
            System.out.println("Ảnh " + name + " chưa được lưu v ào kho!");
            return null;
        }
        return images.get(name);
    }

    public static void loadAllAsset() {
        System.out.println("Đang tải các tài nguyên Ảnh: ");

        loadImage("background_home", "/com/nhom27/skyforce/textures/menu/background.png");

        System.out.println("Tải ảnh hoàn tất!");
    }
}
