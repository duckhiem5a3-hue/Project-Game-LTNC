package com.nhom27.skyforce.Entitiy;

import javafx.scene.image.Image;

public class PlayerObject extends GameObject {
    protected int health;
    protected boolean gettingBuffed;        
    protected int timeInBuff;
    protected int timeSinceLastBullet;
    //default constructor
    public PlayerObject(Image img) {
        super();
        health = 100;
        gettingBuffed = false;
        timeInBuff = 0;
        timeSinceLastBullet = 0;
    }
    //Các phương thức dưới đây để dành cho class GameManager
    /*    
        
        public void createBullet() {
            
            cách tạo đạn tùy thuộc vào trạng thái buff
            có buff tạo 3 đạn bắn 3 hướng mỗi 1s (diagonal bullet)
            không có buff tạo 1 đạn bắn thẳng mỗi 1s
            
        }
        public void checkCollision(BuffObject buffObject) {
            ...
            timeInBuff = 10;
            gettingBuffed = true;
        }
    */
    public void update(){  
        //làm sao để cập nhật biến x,y theo input di chuyển chuột?
        //với fps = 60 thì có cần phải di chuyển tử từ ,hay dịch chuyển mỗi lần update thì cũng khó cảm nhận được?
    }
}