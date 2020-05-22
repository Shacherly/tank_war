package com.mashibing;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    private static final int SPEED = 2;
    private static final int WIDTH = 30, HEIGHT = 30;
    private int x, y;
    private Dir dir;
    private TankFrame tf = null;
    private boolean alive = true;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        // if (!alive) tf.bullets.remove(this);
        tf.bullets.removeIf(b -> !b.alive);
        Color oldColor = g.getColor();
        g.setColor(Color.RED);
        // 圆形子弹
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(oldColor);
        move();
    }

    private void move() {
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y >TankFrame.GAME_HEIGHT) alive = false;
    }

}
