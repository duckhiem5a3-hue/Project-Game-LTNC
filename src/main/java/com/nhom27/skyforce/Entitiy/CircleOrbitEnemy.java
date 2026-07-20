package com.nhom27.skyforce.Entitiy;

import javafx.scene.image.Image;

public class CircleOrbitEnemy extends EnemyObject {
    //default constructor, vị trí khởi tạo 500 0 (phía trên giữa màn hình)
    public CircleOrbitEnemy(Image img) {
        super(img,500,0);
    }
    @Override
    public void update(){  //lấy từ ExperimentUpdate3
        double timeSinceCreation = this.timeLived;
        /*
        - chạy theo hình tròn. 
        - xuất hiện từ vị trí (500,0)
        - chạy thẳng 1 đường xuống vị trí (500, 150) 
        - đây là vị trí bắt đầu quay trên quỹ đạo vòng tròn (quay ngược chiều kim đồng hồ) : 
            - tâm vòng tròn: (500, 400)
            - bán kính vòng tròn: 250 
            - thời gian đi hết 1 vòng tròn: 5s hoặc 300 update 
        - 1 giây (60u) đầu tiên: đi thẳng xuống
        - 1 giây (60u) tiếp theo: quay một góc 90 độ từ góc 180 đến góc 270 
        - sau thời điểm này:
            - công thức chung: 
               x = Tâm + BKinh * cos(pha)
               y = Tâm + Bkinh * sin(pha)
            - góc pha ban đầu: 90
            - 
        */
        double currentX = 0;
        double currentY = 0;
        if(timeSinceCreation <= 60) {
            currentX = 500;
            currentY = (double)150/60*timeSinceCreation;
            this.view.setRotate(180);
        } else if(timeSinceCreation > 60 && timeSinceCreation < 120) {
            currentX = 500;
            currentY = (double)150;
            this.view.setRotate(180 + (double)90*(timeSinceCreation-60)/60);
        } else {
            double coreX = 500;
            double coreY = 400;
            double radius = 250;

            /*vẽ vòng tròn quỹ đạo và mũi tên vector trên trục Ox,Oy của chương trình (Oy ngược Oy trong Oxy cơ bản) sau đó lật về Oxy cơ bản) 
            để hình dung được góc pha ban đầu và hướng quay (-90, cùng chiều kim đồng hồ theo Oxy gốc, 90, ngược kim đồng hồ theo góc nhìn màn hình) 
            */
            currentX = coreX + radius*Math.cos(-Math.PI/2 +  2*Math.PI*(timeSinceCreation-120)/300);
            currentY = coreY + radius*Math.sin(-Math.PI/2 +  2*Math.PI*(timeSinceCreation-120)/300);

            double deltaX = radius*2*Math.PI/300*-Math.sin(-Math.PI/2 +  2*Math.PI*(timeSinceCreation-120)/300);
            double deltaY = radius*2*Math.PI/300*Math.cos(-Math.PI/2 +  2*Math.PI*(timeSinceCreation-120)/300);
            this.view.setRotate(-90 + Math.toDegrees(Math.atan2(deltaY,deltaX)));
        }
        this.x = currentX;
        this.view.setLayoutX(currentX);
        this.y = currentY;
        this.view.setLayoutY(currentY); 

        this.timeLived +=1;    //timeLived tính bằng số lần trải qua update 

        super.checkDeath();
    }
}