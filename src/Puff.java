import java.awt.*;

public abstract class Puff extends FlyingCore {

    protected int posX = GameFrame.FRAME_WIDTH + 200;
    protected int posY;
    protected int speed;
    protected Image[] image = new Image[1];
    private int shiftX;
    private int shiftY;

    protected Rectangle hitBox;

    public Puff(){
        posY = RndEng.rndEng(0, 450);
        speed = RndEng.rndEng(1,11);
    }

    @Override
    protected abstract void drawItem(Graphics g);

    @Override
    protected abstract void reInit();


}
