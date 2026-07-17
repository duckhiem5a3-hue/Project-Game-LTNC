package com.nhom27.skyforce.Entitiy;
import javafx.scene.*;
public abstract class EnemyObject extends GameObject {
    int health;
    public EnemyObject() {
        super();
        health = 100;
    }
    public abstract void update();
    public void CheckCollision(Bullet bullet) {
        
    }
}