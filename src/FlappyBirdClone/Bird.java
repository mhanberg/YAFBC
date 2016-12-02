package FlappyBirdClone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird
{
    BufferedImage bird1 = null;
    int yMotion;
    int topOfBird;
    int bottomOfBird;
    int leftSideOfBird;
    int x;
    int hangTime;
    boolean jumping;
    Boundaries boundaries;

    public Bird() {
        try {
            bird1 = ImageIO.read(new File("../../assets/bird-1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        topOfBird = (FlappyBirdClone.GAMEHEIGHT / 2);
        yMotion = (FlappyBirdClone.GAMEHEIGHT / 2) - (bird1.getHeight() / 2);
        leftSideOfBird = (FlappyBirdClone.GAMEWIDTH / 4);
        x = (FlappyBirdClone.GAMEWIDTH / 4) - (bird1.getWidth() / 2);
        hangTime = 5;
        jumping = false;
        boundaries = new Boundaries(leftSideOfBird, leftSideOfBird + bird1.getWidth(), topOfBird, topOfBird + bird1.getHeight());
    }

    public BufferedImage getBird() {
        return this.bird1;
    }

    public void birdMovement() {
        if (jumping) {
            this.yMotion -= hangTime;
            this.boundaries.updateY(hangTime--);
            if (hangTime < 1) {
                jumping = false;
            }
        } else {
            if (hangTime < -8) {
                this.yMotion += 8;
                this.boundaries.updateY(-8);
            } else {
                this.yMotion += Math.abs(hangTime);
                this.boundaries.updateY(hangTime--);
            }
//            this.yMotion += hangTime < -8 ? 8 : Math.abs(hangTime--);
        }
    }

    public void jump() {
        hangTime = 10;
        jumping = true;
    }

    public int getY() {
        return this.yMotion;
    }

    public int getX() {
        return this.x;
    }

    public Boundaries getBoundaries() {
        return this.boundaries;
    }
}
