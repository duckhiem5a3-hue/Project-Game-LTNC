package com.nhom27.skyforce.Entitiy;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Math;
import java.net.URL;
public abstract class GameObject {
    // 1. Các thuộc tính Logic (Data)
    protected double x, y;      //đa số các method làm việc với Node như setLayout, setFitWidth/Height đều nhận kiểu double 
    protected int timeLived;
    protected Node view;   // 2. Thuộc tính Giao diện (View)
    protected Boolean isAlive;
    public Node getView() {
        return this.view;
    }
    public void setView(String skin) {
        URL imageUrl = getClass().getResource(skin);
        Image img = new Image(imageUrl.toString());
        ImageView imgnode = new ImageView(img);
        this.view = imgnode;
    }
    // Constructor
    public GameObject(Image img, int startX, int startY, int sizeX, int sizeY) {
        //URL imageUrl = getClass().getResource(imgpath);
        //Image img = new Image(imageUrl.toString());
        ImageView imgnode = new ImageView(img);
        this.view = imgnode;
        imgnode.setFitHeight(sizeY);
        imgnode.setFitWidth(sizeX);
        this.x = startX;
        this.y = startY;
        this.isAlive = true;
        // Gắn tọa độ ban đầu cho giao diện
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
    }
    //default constructor
    public GameObject() {
        String imgpath = "/com/nhom27/skyforce/textures/menu/Spaceship1Blue.png";
        URL imageUrl = getClass().getResource(imgpath);
        Image img = new Image(imageUrl.toString());
        ImageView imgnode = new ImageView(img);
        this.view = imgnode;
        imgnode.setFitHeight(200);
        imgnode.setFitWidth(200);
        this.x = 300;
        this.y = 300;
        this.timeLived = 0;
        this.isAlive = true;
        // Gắn tọa độ ban đầu cho giao diện
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
    }
    //constructor with adjustable image and position, default size
    public GameObject(Image img, double startX, double startY) {
        ImageView imgnode = new ImageView(img);
        this.view = imgnode;
        this.x = startX;
        this.y = startY;
        this.isAlive = true;
        // Gắn tọa độ ban đầu cho giao diện
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
    }
    public abstract void update();
}
