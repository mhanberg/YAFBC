package FlappyBirdClone;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

public class FlappyBirdClone extends JFrame implements ActionListener, MouseListener
{

    public static int GAMEHEIGHT = 708;
    public static int GAMEWIDTH = 400;

    public static FlappyBirdClone flappyBirdClone;
    private Engine engine = new Engine();
    private JFrame frame = new JFrame("Flappy Bird: The Shit Edition");

    int gr = 0;
    int pipeTime = 200;
    BufferedImage background = null;
    BufferedImage ground = null;
    ArrayList<BufferedImage> groundPieces;

    Bird bird;
    Pipes pipes;

    public FlappyBirdClone()
    {
        frame.add(engine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addMouseListener(this);

        bird = new Bird();
        pipes = new Pipes();
        pipes.addPipe();
        try
        {
            background = ImageIO.read(new File("../../assets/background.png"));
            ground = ImageIO.read(new File("../../assets/ground.png"));
        }
        catch(IOException e) {  e.printStackTrace();  }
        groundPieces = new ArrayList<>();
        for (int i = 0; i < background.getWidth(); i++)
        {
            groundPieces.add(ground.getSubimage(i, 0, 1, ground.getHeight()));
        }

        frame.setSize(GAMEWIDTH, GAMEHEIGHT);
        Timer timer = new Timer(20, this);
        timer.start();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        engine.repaint();
        bird.birdMovement();
        count();
        pipes.removeHiddenPipe();
        pipes.movePipes();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        bird.jump();
    }

    public void firstPaint(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }

    public void repaint(Graphics g) {
        pipes.drawPipes(g);
        for (int i = 0; i < groundPieces.size(); i++)
        {
            g.drawImage(groundPieces.get((i+ gr) % background.getWidth()), (i), (background.getHeight() - 141), null);
        }
        g.drawImage(bird.getBird(), (frame.getWidth() / 4) - (bird.getBird().getWidth() / 2), bird.getHeight(), null);
    }

    public void count() {
        if (gr < background.getWidth()) {
            gr+=2;
        }  else {
            gr = 0;
        }
        if (pipeTime > 0) {
            pipeTime--;
        } else {
            pipeTime = 200;
            pipes.addPipe();
        }
    }

    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
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
