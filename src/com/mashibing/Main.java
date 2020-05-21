package com.mashibing;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Frame tf = new TankFrame();
        for (; ; ) {
            // 50ms绘制一次
            Thread.sleep(50);
            tf.repaint();

        }

    }
}
