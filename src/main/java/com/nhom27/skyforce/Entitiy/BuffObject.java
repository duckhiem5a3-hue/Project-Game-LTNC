package com.nhom27.skyforce.Entitiy;

import javafx.scene.image.Image;

public class BuffObject extends GameObject { 
    protected double speed;
    //vị trí spawn của BuffObject phụ thuộc vào vị trí EnemyObject chết 
    //constructor, default speed
    public BuffObject(Image img, double startX, double startY) {
        super(img,startX,startY);
        this.speed = 400;
    }
    //constructor, adjustable speed
    public BuffObject(Image img, double startX, double startY, double speed) {
        super(img,startX,startY);
        this.speed = speed;
    }

    //quỹ đạo về cơ bản là ngược với StraightBullet, rớt thẳng xuống màn hình
    @Override
    public void update() {
        y += speed/60;
        view.setLayoutY(y);
        if(this.y >= 1000) {this.isAlive = false;} //buff bay khỏi màn hình 
    }
}
