package com.nhom27.skyforce.Entitiy;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;

public class GameManager {
    private Pane gameLayoutPane;

    private PlayerObject player;
    private List<EnemyObject> enemies = new ArrayList<>();
    private List<Bullet> playerBullets = new ArrayList<>();
    private List<BuffObject> buffs = new ArrayList<>();


    public GameManager(Pane pane) {
        this.gameLayoutPane = pane;
        // Khởi tạo player và gắn vào gameRoot
    }
    /*
    public void checkEnemyBulletCollisions() {
        for(EnemyObject enemy: enemies) {
            for(Bullet bullet: playerBullets) {
                if(enemy.isAlive && bullet.isAlive && enemy.view.intersects(bullet.view));
            }
        }
    }
        */
}
