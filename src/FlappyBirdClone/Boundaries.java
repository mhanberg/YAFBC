package FlappyBirdClone;

/**
 * Created by Mitch on 7/11/2016.
 */
public class Boundaries
{
    int leftX, rightX, upperY, lowerY;

    public Boundaries(int leftX, int rightX, int upperY, int lowerY)
    {
        this.leftX = leftX;
        this.rightX = rightX;
        this.upperY = upperY;
        this.lowerY = lowerY;
    }

    public void updateXes( int movement ) {
        this.leftX -= movement;
        this.rightX -= movement;
    }

    public void updateY(int movement) {
        this.upperY -= movement;
        this.lowerY -= movement;
    }

    public int getLeftX()
    {
        return this.leftX;
    }

    public void updateLeftX(int movement)
    {
        this.leftX -= movement;
    }

    public int getRightX()
    {
        return rightX;
    }

    public void updateRightX(int movement)
    {
        this.rightX -= movement;
    }

    public int getUpperY()
    {
        return upperY;
    }

    public void setUpperY(int upperY)
    {
        this.upperY = upperY;
    }

    public int getLowerY()
    {
        return lowerY;
    }

    public void setLowerY(int lowerY)
    {
        this.lowerY = lowerY;
    }
}
