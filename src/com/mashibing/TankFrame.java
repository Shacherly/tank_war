package com.mashibing;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class TankFrame extends Frame {
    // 老师没有 我自己加的
    private static final boolean KEY_PRESSED = true;
    private static final boolean KEY_RELEASED = false;

    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    // private static final

    Tank myTank = new Tank(200, 200, Dir.DOWN, this);
    Bullet bullet = new Bullet(300, 300, Dir.DOWN, this);
    // 使用juc的ArrayList防止出问题
    List<Bullet> bullets = new CopyOnWriteArrayList<>();

    /**
     * Constructs a new instance of {@code Frame} that is
     * initially invisible.  The title of the {@code Frame}
     * is empty.
     * @exception HeadlessException when
     *     {@code GraphicsEnvironment.isHeadless()} returns {@code true}
     * @see GraphicsEnvironment#isHeadless()
     * @see Component#setSize
     * @see Component#setVisible(boolean)
     */
    public TankFrame() throws HeadlessException {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                // super.windowClosing(e);
            }
        });

        addKeyListener(new SlefKeyListener());
    }

    // 去掉屏幕闪烁
    Image offScreenImage = null;

    // update会在paint调用之前被调用
    @Override
    public void update(Graphics g) {
        if (Objects.isNull(offScreenImage))
            offScreenImage = createImage(GAME_WIDTH, GAME_HEIGHT);
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        // 文字提示子弹数量
        Color oldColor = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("数量: " + bullets.size(), 10, 60);
        g.setColor(oldColor);

        // 添加黑色小方块
        myTank.paint(g);
        // bullet.paint(g);// 一个子弹直接paint，多个子弹遍历paint
        bullets.forEach(b -> b.paint(g));// forEach调用的是迭代器，如果期间集合被修改会报异常
        // for (int i = 0; i < bullets.size(); i++) {
        //     bullets.get(i).paint(g);
        // }


        // 确实可以吧myTank的各个属性都取出来使用，但是这样显然破坏了封装的思想，
        /*那我直接把这些方法封装到Tank类中move方法，移动是应该是自己主动说移动
        g.fillRect(x, y, 50, 50);
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
        }*/
    }

    class SlefKeyListener extends KeyAdapter {
        // 上右下左四个方向为true表示keyPressed确认该方向 ，false表示keyRelease取消改方向
        boolean left = false;
        boolean up = false;
        boolean right = false;
        boolean down = false;


        /**
         * Invoked when a key has been pressed.
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
            // x += 200;
            // 重新绘制窗口，我们无法主动调用上面重写的paint方法，因为Graphics画笔只有系统才有
            // repaint();
            int keyCode = e.getKeyCode();
            keyProcesser(keyCode, KEY_PRESSED);

            setMainTankDir();
        }

        /**
         * Invoked when a key has been released.
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            // System.out.println("keyReleased");
            int keyCode = e.getKeyCode();
            // 切换方向
            keyProcesser(keyCode, KEY_RELEASED);

            setMainTankDir();
        }

        private void setMainTankDir() {
            if ((!up && !right && !down && !left)) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (left) myTank.setDir(Dir.LEFT);
                if (up) myTank.setDir(Dir.UP);
                if (right) myTank.setDir(Dir.RIGHT);
                if (down) myTank.setDir(Dir.DOWN);
            }

        }

        private void keyProcesser(int keyCode, boolean keyStatus) {
            switch (keyCode) {
                // virtual key left
                case KeyEvent.VK_LEFT:
                    left = keyStatus;
                    break;
                case KeyEvent.VK_UP:
                    up = keyStatus;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = keyStatus;
                    break;
                case KeyEvent.VK_DOWN:
                    down = keyStatus;
                    break;
                // 增加CTRL键释放时发射子弹
                case KeyEvent.VK_CONTROL:
                    // 因为是个公共方法，所以出现了按一次发射两次的bug
                    // 判断如果是释放就开火
                    if (!keyStatus) myTank.fire();
                    break;
                default:
                    break;
            }
        }
    }
}
