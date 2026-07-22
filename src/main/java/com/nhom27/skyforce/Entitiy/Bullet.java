package com.nhom27.skyforce.Entitiy;
import com.nhom27.skyforce.main.Main;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Bullet extends GameObject {
    protected double speed;
    protected double incline; //độ nghiêng (đi một đoạn theo trục y thì đi bao nhiêu theo trục x)
    //protected Boolean fromPlayer;     

    //Constructor có tham số startX, startY do tọa độ spawn của bullet phụ thuộc vào tọa độ của PlayerObject. Default speed and size (400 pixel/giây, 45*85)
    //không như 
    public Bullet(Image img, double startX, double startY ,double incline) {
        super(img, startX, startY);
        speed = 400;
        this.incline = incline;
        this.view.setRotate(Math.toDegrees(Math.atan2(x,y)));
        this.hitbox = new Rectangle(45,85); 
        this.setPos(startX, startY, incline);
        /*debug kiểm tra hitbox
        this.hitbox.setFill(Color.TRANSPARENT);
        this.hitbox.setStroke(Color.RED);      // Viền đỏ
        this.hitbox.setStrokeWidth(2);
        */
    }
    //Constructor, adjustable speed
    public Bullet(Image img, double startX, double startY ,double sizeX, double sizeY,double incline, double speed) {
        super(img, startX, startY);
        this.speed = speed;
        this.incline = incline;
        this.hitbox = new Rectangle(sizeX,sizeY); 
        this.view.setFitHeight(sizeY);
        this.view.setFitWidth(sizeX);
        this.view.setRotate(Math.toDegrees(Math.atan2(x,y)));
        this.setPos(startX, startY, incline);
    }
    public void update() {
        x += speed/60*incline;
        y -= speed/60;
        double rotateAngle = Math.toDegrees(Math.atan2(x,y));
        this.setPos(x,y,rotateAngle);
        if(this.x < 0 || this.x > Main.WIDTH || this.y < 0 || this.y > Main.HEIGHT) {
            this.isAlive = false;
        };
    }
    /*
    các class con StraightBullet và DiagonalBullet bị xóa bỏ
    Field incline được sinh ra để tạo độ nghiêng cho đạn 
    incline dương: nghiêng sang phải
    incline âm: nghiêng sang trái
    incline bằng 0: không nghiêng (straight bullet)
    */
}
