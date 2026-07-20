package com.nhom27.skyforce.Entitiy;

public class PlayerObject extends GameObject {
    private int health;
    private boolean gettingBuffed1;        
    private boolean gettingBuffed2;
    private int timeInBuff1;
    private int timeInBuff2;
    private int timeSinceLastBullet;
    //default constructor
    public PlayerObject() {
        super();
        health = 100;
        gettingBuffed2 = false;
        gettingBuffed1 = false;
        int timeInBuff1 = 0;
        int timeInBuff2 = 0;
        int timeSinceLastBullet = 0;
    }
    public void checkBuff() {
        if(timeInBuff1 > 0) {gettingBuffed1 = true;}
        if(timeInBuff2 > 0) {gettingBuffed2 = true;}
    }
    public void createBullet() {
        /*
        cách tạo đạn tùy thuộc vào trạng thái buff
        buff1 tạo 3 đạn bắn 3 hướng mỗi 1s
        buff2 tạo 1 đạn bắng thẳng mỗi 0.25s
        không có buff tạo 1 đạn bắn thẳng mỗi 1s
        nên trả về kiểu void hay bullet? nên lưu đạn vào đâu? 
        */
    }
    public void checkCollision(BuffObject buffObject) {

    }
    public void update(){  
        
    }
}