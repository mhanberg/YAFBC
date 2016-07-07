package FlappyBirdClone;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mitch on 7/3/2016.
 */
public class Engine extends JPanel
{
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        FlappyBirdClone.flappyBirdClone.firstPaint(g);
        FlappyBirdClone.flappyBirdClone.repaint(g);
    }
}
