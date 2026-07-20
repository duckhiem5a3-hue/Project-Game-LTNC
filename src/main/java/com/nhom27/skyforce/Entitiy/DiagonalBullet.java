package com.nhom27.skyforce.Entitiy;

import javafx.scene.image.Image;

public class DiagonalBullet extends Bullet {
    //constructor: default speed , adjustable incline
    public DiagonalBullet(Image img, double startX, double startY, double incline) {
        super(img,startX, startY ,incline);
        this.view.setRotate(Math.toDegrees(Math.atan2(x,y)));
    }
    //constructor: adjustable speed and incline
    //nếu đặt incline là âm thì đạn sẽ rẽ sang trái, đặt là dương thì rẽ sang phải
    public DiagonalBullet(Image img, double startX, double startY, double incline, double speed) {
        super(img,startX, startY ,incline ,speed);
        this.view.setRotate(Math.toDegrees(Math.atan2(x,y)));
    }
    @Override
    public void update() {
        x += speed/60*incline;
        y -= speed/60;
        view.setLayoutY(y);
        view.setLayoutX(x);
        super.checkOutOfScreen();
    }
}
