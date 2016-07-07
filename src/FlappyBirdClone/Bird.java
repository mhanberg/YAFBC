package FlappyBirdClone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird
{
    BufferedImage bird1 = null;
    int elevation;

    public Bird() {
        try {
            bird1 = ImageIO.read(new File("../../assets/bird-1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        elevation = (FlappyBirdClone.GAMEHEIGHT / 2) - (bird1.getHeight() / 2);

    }

    public BufferedImage getBird() {
        return this.bird1;
    }

    public void jump() {
        this.elevation -= 5;
    }

    public int getHeight() {
        return this.elevation;
    }
}
