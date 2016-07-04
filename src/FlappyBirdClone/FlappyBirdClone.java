package FlappyBirdClone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class FlappyBirdClone extends JFrame implements ActionListener
{
    public static FlappyBirdClone flappyBirdClone;
    private Engine engine = new Engine();
    private JFrame frame = new JFrame("Flappy Bird: The Shit Edition");

    private Rectangle bird;

    public FlappyBirdClone()
    {
        frame.add(engine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);





        bird = new Rectangle(400, 400, 20, 20);

        Timer timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        engine.repaint();
    }

    public void repaint(Graphics g)
    {
        g.setColor(new Color(153, 204, 255));
        g.fillRect(0, 0, 800, 800);

        g.setColor(Color.green);
        g.fillRect(0, 650, 800, 20);

        g.setColor(new Color(153, 76, 0));
        g.fillRect(0, 670, 800, 130);

        g.setColor(Color.yellow);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);
    }
    public static void main(String[] args)
    {

        flappyBirdClone = new FlappyBirdClone();


    }


}
