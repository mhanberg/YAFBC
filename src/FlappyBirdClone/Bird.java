package FlappyBirdClone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird
{
    BufferedImage bird1 = null;
    int yMotion;
    int hangTime;
    boolean jumping;

    public Bird() {
        try {
            bird1 = ImageIO.read(new File("../../assets/bird-1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        yMotion = (FlappyBirdClone.GAMEHEIGHT / 2) - (bird1.getHeight() / 2);
        hangTime = 5;
        jumping = false;

    }

    public BufferedImage getBird() {
        return this.bird1;
    }

    public void birdMovement() {
        if (jumping) {
            this.yMotion -= hangTime--;
            if (hangTime < 1) {
                jumping = false;
            }
        } else {
            this.yMotion += hangTime < -8 ? 8 : Math.abs(hangTime--);
        }
    }

    public void jump() {
        hangTime = 10;
        jumping = true;
    }

    public int getHeight() {
        return this.yMotion;
    }

}
