package com.mashibing;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    private static final int SPEED = 7;
    // 子弹的宽高
    public static final int WIDTH, HEIGHT;
    // x y 是坐标
    private int x, y;
    private Dir dir;
    private TankFrame tf = null;
    private boolean alive = true;

    static {
        WIDTH = ResourceMgr.bulletUp.getWidth();
        HEIGHT = ResourceMgr.bulletUp.getHeight();
    }

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        // if (!alive) tf.bullets.remove(this);
        tf.bullets.removeIf(b -> !b.alive);
        /*Color oldColor = g.getColor();
        g.setColor(Color.RED);
        // 圆形子弹
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(oldColor);*/
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.bulletUp, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletRight, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletDown, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletLeft, x, y, null);
                break;

        }
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) alive = false;
    }

}
