package FlappyBirdClone;

import java.awt.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Pipes
{
    LinkedList<Pipe> pipes;

    public Pipes() {
        pipes = new LinkedList<>();
    }

    public synchronized void addPipe() {
        this.pipes.add(new Pipe());
    }

    public synchronized void removeHiddenPipe() {
        ListIterator<Pipe> iterator = pipes.listIterator();

        while(iterator.hasNext()) {
            Pipe potentiallyHiddenPipe = iterator.next();
            if (potentiallyHiddenPipe.getXMotion() < -60) {
                iterator.remove();
            }

        }
        for(Pipe pipe : pipes) {
            if (pipe.getXMotion() < -60) {
                pipes.remove(pipe);
            }
        }
    }

    public void movePipes() {
        for (Pipe pipe: pipes) {
            pipe.movePipe();
        }
    }

    public void drawPipes(Graphics g) {
        for (Pipe pipe: pipes) {
            g.drawImage(pipe.getPipe("top"), pipe.getXMotion(), pipe.getHeight("top"), null);
            g.drawImage(pipe.getPipe("bottom"), pipe.getXMotion(), pipe.getHeight("bottom"), null);
        }
    }
}
