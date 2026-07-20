package com.nhom27.skyforce.Entitiy;

import javafx.scene.image.Image;

public class SineOrbitEnemy extends EnemyObject {
    //adjustable starting height
    public SineOrbitEnemy(Image img, double startX) {
        super(img,startX,0);
    }
    //default starting height (vị trí khởi tạo bên trái gần trên màn hình
    public SineOrbitEnemy(Image img) {       
        super(img,300,0);
    }
    @Override
    public void update(){  //lấy từ ExperimentUpdate2
        /*
        - chạy theo hình sin, đi 1 chu kì hình sin từ bên trái sang bên phải màn hình    
        - chạy được 1 chu kì trong 5s (300 update)   (sin(2pi) = sin(1/150pi * 300update)) 
        - chạy được hết màn hình 1200 pixel trong 5s
        - độ lệch pha tối đa 200 pixel
        */
        double timeSinceCreation = this.timeLived%300;  //đưa x quay trở lại 0 (rìa trái màn hình) sau khi nó đã đi hết rìa phải

        double currentX = 4 * timeSinceCreation;
        double currentY = 300 + 200 * Math.sin(timeSinceCreation * Math.PI / 150);

        //cập nhật thay đổi bằng đạo hàm (vận tốc tức thì là đạo hàm của quãng đường) 
        double deltaX = 4.0;
        double deltaY = (4 * Math.PI / 3) * Math.cos(timeSinceCreation * Math.PI / 150);

        this.x = currentX;
        this.view.setLayoutX(currentX);
        this.y = currentY;
        this.view.setLayoutY(currentY);
        this.view.setRotate(90 + Math.toDegrees(Math.atan2(deltaY,deltaX)));
        
        this.timeLived +=1;    //timeLived tính bằng số lần trải qua update 

        super.checkDeath();
    }
}
