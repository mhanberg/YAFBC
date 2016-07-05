package FlappyBirdClone;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

public class FlappyBirdClone extends JFrame implements ActionListener
{
    public static FlappyBirdClone flappyBirdClone;
    private Engine engine = new Engine();
    private JFrame frame = new JFrame("Flappy Bird: The Shit Edition");

    int t = 0;
    BufferedImage bird1 = null;
    BufferedImage background = null;
    BufferedImage ground = null;
    ArrayList<BufferedImage> groundPieces;
    BufferedImage topPipe = null;
    BufferedImage bottomPipe = null;


    public FlappyBirdClone()
    {
        frame.add(engine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        try
        {
            bird1 = ImageIO.read(new File("../../assets/bird-1.png"));
            background = ImageIO.read(new File("../../assets/background.png"));
            ground = ImageIO.read(new File("../../assets/ground.png"));
            topPipe = ImageIO.read(new File("../../assets/top-pipe.png")); //not implemented yet
            bottomPipe = ImageIO.read(new File("../../assets/bottom-pipe.png")); //not implemented yet
        }
        catch(IOException e) {  e.printStackTrace();  }
        groundPieces = new ArrayList<BufferedImage>();
        for (int i = 0; i < background.getWidth(); i++)
        {
            groundPieces.add(ground.getSubimage(i, 0, 1, ground.getHeight()));
        }

        frame.setSize(background.getWidth(), background.getHeight());
        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        engine.repaint();
        tick();
    }

    public void repaint(Graphics g)
    {
        g.drawImage(background, 0, 0, null);
        for (int i = 0; i < groundPieces.size(); i++)
        {
            g.drawImage(groundPieces.get((i+t) % background.getWidth()), (i), (background.getHeight() - 141), null);
        }
        g.drawImage(bird1, (frame.getWidth() / 4) - (bird1.getWidth() / 2), (frame.getHeight() / 2) - (bird1.getHeight() / 2), null);
    }

    public void tick() {
        if (t < background.getWidth())
        {
            t++;
        }
        else
        {
            t = 0;
        }
    }
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    flappyBirdClone = new FlappyBirdClone();
                }
                catch(Exception e) { e.printStackTrace(); }
            }
        });
    }
}
