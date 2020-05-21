package com.mashibing;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

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
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

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
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        /**
         * Invoked when a key has been released.
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            // System.out.println("keyReleased");
            int key = e.getKeyCode();
            // 切换方向
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;

            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (bL) myTank.setDir(Dir.LEFT);
            if (bU) myTank.setDir(Dir.UP);
            if (bR) myTank.setDir(Dir.RIGHT);
            if (bD) myTank.setDir(Dir.DOWN);
        }
    }
}
