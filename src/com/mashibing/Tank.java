package com.mashibing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;


    @Override
    public String toString() {
        return "Tank{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                '}';
    }

    public void paint(Graphics g) {
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
        }
        // x += 10;
        // y += 10;
    }
}
