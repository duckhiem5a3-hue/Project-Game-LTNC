package com.nhom27.skyforce.Entitiy;
import javafx.scene.*;
import javafx.scene.image.Image;
public abstract class EnemyObject extends GameObject {
    protected int health;
    //parameter with position and image
    public EnemyObject(Image img, double startX, double startY) {
        super(img,startX,startY);
        health = 100;
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