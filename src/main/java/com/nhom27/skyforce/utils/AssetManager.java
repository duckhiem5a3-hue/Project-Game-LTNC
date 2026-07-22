package com.nhom27.skyforce.utils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

public class AssetManager {
    public static final Map<String, Image> images = new HashMap();
    public static final Map<String, Media> musics = new HashMap();
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
            System.out.println("Ảnh " + name + " chưa được lưu vào kho!");
            return null;
        }
        return images.get(name);
    }
    public static void loadMusic(String name, String path) {
        if (!musics.containsKey(name)) {
            URL musicUrl = AssetManager.class.getResource(path);
            if (musicUrl != null) {
                Media media = new Media(musicUrl.toString());
                musics.put(name, media);
                System.out.println("Tải thành công nhạc: " + name);
            } else {
                System.out.println("Lỗi tải nhạc: " + name);
            }
        }
    }
    public static Media getMusic(String name) {
        if (!musics.containsKey(name)) {
            System.out.println("Nhạc " + name + " chưa được lưu vào kho!");
            return null;
        }
        return musics.get(name);
    }
    public static void loadAllAsset() {
        System.out.println("Đang tải các tài nguyên Ảnh: ");
        loadImage("background_home", "/com/nhom27/skyforce/textures/menu/background.png");
        System.out.println("Tải ảnh hoàn tất!");

        System.out.println("Đang tải các tài nguyên Âm Thanh: ");
        loadMusic("background_home_music", "/com/nhom27/skyforce/sounds/background.mp3");
        System.out.println("Tải nhạc hoàn tất!");

        loadImage("Spaceship1Blue", "/com/nhom27/skyforce/textures/Spaceship1Blue");
    }
    public static double[] getShapePlane1(double sizeX, double sizeY) {
        double[] plane1 = new double[]{  //vẽ viền theo máy bay số 1
            0.425*sizeX     ,  0.225*sizeY,
            0.575*sizeX     ,  0.225*sizeY,
            0.575*sizeX     ,  0.45*sizeY,
            0.9*sizeX       ,  0.55*sizeY,
            0.5*sizeX       ,  0.8*sizeY,
            0.1*sizeX       ,  0.55*sizeY, 
            0.425*sizeX     ,  0.45*sizeY,
            0.425*sizeX     ,  0.225*sizeY,
        };
        return plane1;
    }
    public static double[] getBulletShape(double sizeX, double sizeY) {
        double[] bullet1 = new double[]{
            0,0,
            0,sizeY,
            sizeX, sizeY,
            sizeX, 0,
        };
        return bullet1;
    }
}
