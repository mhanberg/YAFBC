package FlappyBirdClone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Pipe
{
    Random rand = new Random();

    int topPipeHeight;
    int bottomPipeHeight;
    int pipeDistance = 100;
    int maxTopHeight = -534;
    int minTopHeight = -100;
    int xMotion = 500;
    BufferedImage topPipe = null;
    BufferedImage bottomPipe = null;

    public Pipe() {
        try {
            topPipe = ImageIO.read(new File("../../assets/top-pipe.png"));
            bottomPipe = ImageIO.read(new File("../../assets/bottom-pipe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        topPipeHeight = rand.nextInt(minTopHeight - maxTopHeight) - 534;
        bottomPipeHeight = topPipeHeight + topPipe.getHeight() + pipeDistance;
    }

    public BufferedImage getPipe(String whichPipe) {
        if (whichPipe.equalsIgnoreCase("top")) {
            return topPipe;
        } else if (whichPipe.equalsIgnoreCase("bottom")) {
            return bottomPipe;
        } else {
            return null;
        }
    }

    public int getHeight(String whichPipe) {
        if (whichPipe.equalsIgnoreCase("top")) {
            return topPipeHeight;
        } else {
            return bottomPipeHeight;
        }
    }

    public void movePipe() {
        this.xMotion--;
    }

    public int getXMotion() {
        return this.xMotion;
    }
}
