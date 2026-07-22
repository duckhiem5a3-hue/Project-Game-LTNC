package com.nhom27.skyforce.Entitiy;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.shape.Polygon;
public abstract class EnemyObject extends GameObject {
    protected int health;
    //parameter with position and image
    public EnemyObject(Image img, double startX, double startY, double sizeX, double sizeY, double[] hitbox) {
        super(img,startX,startY,sizeX,sizeY);
        health = 100;
        this.hitbox = new Polygon(hitbox);   //có thể điền hitbox là AssetManager.getShapePlane1(sizeX,sizeY)
        /* đoạn này để hiện hitbox
        this.hitbox.setFill(Color.TRANSPARENT);
        this.hitbox.setStroke(Color.RED);      
        this.hitbox.setStrokeWidth(2);
        */
    }
    protected void checkDeath() { //method được lồng vào update() ở các class con
        if(this.health <=0) {this.isAlive = false;}
    }
    public abstract void update();

    //method này sẽ giao cho GameManager quản lí
    /*
        public void CheckCollision(Bullet bullet) {
            
        }
    */
}