package com.mashibing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tank {
    // 左上角绝对坐标
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tf = null;
    // 是否触碰到边缘
    private boolean border = false;

    // 坦克的宽高
    public static final int WIDTH, HEIGHT;

    static {
        WIDTH = ResourceMgr.tankUp.getWidth();
        HEIGHT = ResourceMgr.tankUp.getHeight();
    }

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
        // 移动过程中需要自己判断是否触碰边界
        // 其实本来可以在TankFrame中获取到x, y坐标进行判断，但是

        if (!moving) return;
        switch (dir) {
            case LEFT:
                if (x != 0)// 如果左边缘了则不让移动的
                    x -= SPEED;
                break;
            case UP:
                if (y != 0)
                    y -= SPEED;
                break;
            case RIGHT:
                if (x != TankFrame.GAME_WIDTH - WIDTH)
                    x += SPEED;
                break;
            case DOWN:
                if (y != TankFrame.GAME_HEIGHT - HEIGHT)
                    y += SPEED;
                break;
        }

    }

    public void fire() {
        // frame窗口中需要子弹对象
        // tf.bullet = new Bullet(x, y, dir);// 单个子弹可以new
        System.out.println(String.format("宽：%s,高：%s", WIDTH, HEIGHT));
        tf.bullets.add(
                new Bullet(x + (WIDTH - Bullet.WIDTH) / 2, y + (HEIGHT - Bullet.HEIGHT) / 2, dir, tf)
        );// 多个子弹就加进去
    }
}
