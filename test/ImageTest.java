

import junit.framework.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

public class ImageTest {

    @Test
    public void test() {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("profile.jpg");
            Assert.assertNotNull(in);

            ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
