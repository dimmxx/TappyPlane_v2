import java.awt.*;

public abstract class FlyingCore {

    private int impact;

    private Image[] image;

    private int posX;
    private int posY;
    private int speed;

    private int rotate = 0;

    private Rectangle hitBox;

    protected abstract void drawItem (Graphics g);

    protected abstract void reInit();

}