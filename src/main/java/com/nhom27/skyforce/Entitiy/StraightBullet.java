package com.nhom27.skyforce.Entitiy;

import javafx.scene.image.Image;

public class StraightBullet extends Bullet {
    //default speed
    public StraightBullet(Image img, double startX, double startY) {
        super(img,startX,startY,0,400);
    }
    //adjustable speed
    public StraightBullet(Image img, double startX, double startY, double speed) {
        super(img,startX,startY,0,speed);
    }
    @Override
    public void update() {
        y -= speed/60;
        view.setLayoutY(y);
        super.checkOutOfScreen();
    }
}
