package com.nhom27.skyforce.Entitiy;
import com.nhom27.skyforce.main.Main;

import javafx.scene.image.Image;

public abstract class Bullet extends GameObject {
    protected double speed;
    protected double incline; //độ nghiêng (đi một đoạn theo trục y thì đi bao nhiêu theo trục x)

    //Constructor có tham số startX, startY do tọa độ spawn của bullet phụ thuộc vào tọa độ của PlayerObject. Default speed (400 pixel/giây)
    public Bullet(Image img, double startX, double startY ,double incline) {
        super(img, startX, startY);
        speed = 400;
    }
    //Constructor, adjustable speed
    public Bullet(Image img, double startX, double startY ,double incline, double speed) {
        super(img, startX, startY);
        this.speed = speed;
    }
    protected void checkOutOfScreen() {   //sẽ được sử dụng bởi hàm update()
        if(this.x < 0 || this.x > Main.WIDTH || this.y < 0 || this.y > Main.HEIGHT) {
            this.isAlive = false;
        };
    }
    public abstract void update();
}
