package FlappyBirdClone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Pipe
{
    Random rand = new Random();

    int topPipeY;
    int bottomPipeY;
    int pipeDistance = 150;
    int maxTopHeight = -534;
    int minTopHeight = -150;
    int x = 500;
    BufferedImage topPipe = null;
    BufferedImage bottomPipe = null;
    Boundaries boundaries;

    public Pipe()
    {
        try
        {
            topPipe = ImageIO.read(new File("../../assets/top-pipe.png"));
            bottomPipe = ImageIO.read(new File("../../assets/bottom-pipe.png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        topPipeY = rand.nextInt(minTopHeight - maxTopHeight) - 534;
        bottomPipeY = topPipeY + topPipe.getHeight() + pipeDistance;

        boundaries = new Boundaries(x, x + topPipe.getWidth(), topPipeY + topPipe.getHeight(), bottomPipeY);
    }

    public BufferedImage getPipe(String whichPipe)
    {
        if (whichPipe.equalsIgnoreCase("top"))
        {
            return topPipe;
        } else if (whichPipe.equalsIgnoreCase("bottom"))
        {
            return bottomPipe;
        } else
        {
            return null;
        }
    }

    public int getHeight(String whichPipe)
    {
        if (whichPipe.equalsIgnoreCase("top"))
        {
            return topPipeY;
        } else
        {
            return bottomPipeY;
        }
    }

    public void movePipe()
    {
        this.x -= FlappyBirdClone.SPEED;
        this.boundaries.updateXes(2);
    }

    public int getXMotion()
    {
        return this.x;
    }

    public Boundaries getBoundaries() {
        return this.boundaries;
    }
}
