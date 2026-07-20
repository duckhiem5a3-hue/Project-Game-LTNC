package com.nhom27.skyforce.Entitiy;

import javafx.scene.image.Image;

public class DiagonalBullet extends Bullet {
    //default incline: arctan(2) khoảng 37 độ so với phương thẳng đứng 
    //constructor: default incline, speed
    public DiagonalBullet(Image img, double startX, double startY) {
        super(img,startX, startY ,0.5);
    }
    //constructor: adjustable speed
    public DiagonalBullet(Image img, double startX, double startY, double incline, double speed) {
        super(img,startX, startY ,incline,speed);
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
