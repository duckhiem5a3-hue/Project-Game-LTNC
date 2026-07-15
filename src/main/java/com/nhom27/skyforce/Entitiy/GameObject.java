package com.nhom27.skyforce.Entitiy;
import javafx.scene.*;
public class GameObject {
    // 1. Các thuộc tính Logic (Data)
    private int x, y;
    private int speed;

    public int getX() {
        return this.x;
    } 
    public int getY() {
        return this.y;
    }
    public void setX(int newX) {
        this.x = newX;
    }
    public void setY(int newY) {
        this.y = newY;
    }
    // 2. Thuộc tính Giao diện (View)
    private Node view; // Dùng kiểu Node để có thể linh hoạt chứa ImageView, Shape, hay Group đều được.
    public Node getView() {
        return this.view;
    }
    public void setView(Node skin) {
        this.view = skin;
    }


    // Constructor
    public GameObject(Node view, int startX, int startY) {
        this.view = view;
        this.x = startX;
        this.y = startY;
        
        // Gắn tọa độ ban đầu cho giao diện
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
    }


    // 3. Hàm cập nhật mỗi khung hình
    public void update() {
        x -= speed; 
        view.setLayoutX(x); 
    }

    // Getter để nhét vật thể này vào Layout (Pane)
    
}
