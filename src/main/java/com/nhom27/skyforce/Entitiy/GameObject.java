package com.nhom27.skyforce.Entitiy;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Math;
import java.net.URL;
public abstract class GameObject {
    // 1. Các thuộc tính Logic (Data)
    protected double x, y;      //đa số các method làm việc với Node như setLayout, setFitWidth/Height đều nhận kiểu double 
    protected int timeLived;
    
    // 2. Thuộc tính Giao diện (View)
    protected Node view; // Dùng kiểu Node để có thể linh hoạt chứa ImageView, Shape, hay Group đều được.
    public Node getView() {
        return this.view;
    }
    public void setView(String skin) {
        URL imageUrl = getClass().getResource(skin);
        Image img = new Image(imageUrl.toString());
        ImageView imgnode = new ImageView(img);
        this.view = imgnode;
    }


    // Constructor
    public GameObject(String imgpath, int startX, int startY, int sizeX, int sizeY) {
        URL imageUrl = getClass().getResource(imgpath);
        Image img = new Image(imageUrl.toString());
        ImageView imgnode = new ImageView(img);
        this.view = imgnode;
        imgnode.setFitHeight(sizeY);
        imgnode.setFitWidth(sizeX);
        this.x = startX;
        this.y = startY;
        // Gắn tọa độ ban đầu cho giao diện
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
    }
    //default constructor
    public GameObject() {
        String imgpath = "/com/nhom27/skyforce/textures/menu/Spaceship1Blue.png";
        URL imageUrl = getClass().getResource(imgpath);
        Image img = new Image(imageUrl.toString());
        ImageView imgnode = new ImageView(img);
        this.view = imgnode;
        imgnode.setFitHeight(200);
        imgnode.setFitWidth(200);
        this.x = 300;
        this.y = 300;
        this.timeLived = 0;
        // Gắn tọa độ ban đầu cho giao diện
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
    }
    public abstract void update();
    public void ExperimentUpdate2(int timeSinceCreation) { //thời gian tính theo đơn vị update = 1/60s
        /*
        - chạy theo hình sin, đi 1 chu kì hình sin từ bên trái sang bên phải màn hình    
        - chạy được 1 chu kì trong 5s (300 update)   (sin(2pi) = sin(1/150pi * 300update)) 
        - chạy được hết màn hình 1200 pixel trong 5s
        - độ lệch pha tối đa 200 pixel
        */

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
    }

    public void ExperimentUpdate3(int timeSinceCreation) {
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
    }
}
