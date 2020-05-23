package com.mashibing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * 资源管理者
 */
public class ResourceMgr {
    public static BufferedImage tankUp, tankRight, tankDown, tankLeft;
    public static BufferedImage bulletUp, bulletRight, bulletDown, bulletLeft;
    private static final ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();

    static {
        try {
            tankUp = ImageIO.read(load("images/tankU.gif"));
            tankRight = ImageIO.read(load("images/tankR.gif"));
            tankDown = ImageIO.read(load("images/tankD.gif"));
            tankLeft = ImageIO.read(load("images/tankL.gif"));

            bulletUp = ImageIO.read(load("images/bulletU.gif"));
            bulletRight = ImageIO.read(load("images/bulletR.gif"));
            bulletDown = ImageIO.read(load("images/bulletD.gif"));
            bulletLeft = ImageIO.read(load("images/bulletL.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static InputStream load(String resource) {
        return CLASS_LOADER.getResourceAsStream(resource);
    }
}
