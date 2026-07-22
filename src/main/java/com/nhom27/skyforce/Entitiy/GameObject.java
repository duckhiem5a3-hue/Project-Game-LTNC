package com.nhom27.skyforce.Entitiy;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

import java.lang.Math;
import java.net.URL;
public abstract class GameObject {
    // 1. Các thuộc tính Logic (Data)
    protected double x, y;      //đa số các method làm việc với Node như setLayout, setFitWidth/Height đều nhận kiểu double 
    protected int timeLived;
    protected ImageView view;   // 2. Thuộc tính Giao diện (View)
    protected Boolean isAlive;
    protected Shape hitbox;  // Thuộc tính đa giác (dùng để kiểm tra va chạm) 
    public Node getView() {
        return this.view;
    }
    public void setView(String skin) {
        URL imageUrl = getClass().getResource(skin);
        Image img = new Image(imageUrl.toString());
        ImageView imgnode = new ImageView(img);
        this.view = imgnode;
    }
    public Shape getHitbox() {
        return this.hitbox;
    }
    //setter cập nhật vị trí và góc của EnemyObject
    public void setPos(double currentX, double currentY, double rotateAngle) {
        this.x = currentX;
        this.y = currentY;
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
        this.view.setRotate(rotateAngle);
        this.hitbox.setLayoutX(x);
        this.hitbox.setLayoutY(y);
        this.hitbox.setRotate(rotateAngle);
    }
    public void setPos(double currentX, double currentY) {
        this.x = currentX;
        this.y = currentY;
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
        this.view.setRotate(this.view.getRotate());
        this.hitbox.setLayoutX(x);
        this.hitbox.setLayoutY(y);
        this.hitbox.setRotate(this.view.getRotate());
    }
    // Constructor
    public GameObject(Image img, double startX, double startY, double sizeX, double sizeY) {
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
