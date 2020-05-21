package com.mashibing;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private static final boolean KEY_PRESSED = true;
    private static final boolean KEY_RELEASED = false;

    Tank myTank = new Tank(200, 200, Dir.DOWN);


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
        setSize(800, 600);
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

    @Override
    public void paint(Graphics g) {
        // 添加黑色小方块
        myTank.paint(g);
        // 确实可以吧myTank的各个属性都取出来使用，但是这样显然破坏了封装的思想，
        /*那我直接把这些方法封装到Tank类中
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
        // x += 10;
        // y += 10;
    }

    class SlefKeyListener extends KeyAdapter {
        // 上右下左四个方向为true表示keyPressed ，false表示keyRelease
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
            if (!up && !right && !down && !left) myTank.setMoving(false);
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
                default:
                    break;
            }
        }
    }
}
