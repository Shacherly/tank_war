package com.mashibing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        Color c = g.getColor();
        // g.setColor(Color.YELLOW);
        // g.fillRect(x, y, 50, 50);
        // g.setColor(c);
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.tankUp, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankRight, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankDown, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankLeft, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    public void fire() {
        // frame窗口中需要子弹对象
        // tf.bullet = new Bullet(x, y, dir);// 单个子弹可以new
        tf.bullets.add(new Bullet(x, y, dir, tf));// 多个子弹就加进去
    }
}
