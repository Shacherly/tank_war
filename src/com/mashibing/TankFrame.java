package com.mashibing;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x = 200, y = 200;

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
        g.fillRect(x, y, 50, 50);
        x += 10;
        y += 10;
    }

    class SlefKeyListener extends KeyAdapter {
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
        }

        /**
         * Invoked when a key has been released.
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
        }
    }
}
