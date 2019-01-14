import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Coin extends FlyingCore{

    Image[] image = new Image[6];

    private int posX = GameFrame.FRAME_WIDTH + 50;
    private int posY = RndEng.rndEng(30, 500);

    private int speed = RndEng.rndEng(1, 11);

    private int coinRotate = 0;

    private Rectangle hitBox = new Rectangle(posX, posY, 30, 30);


    public Coin(){
        for(int i = 0; i < 6; i++) {
            try {
                image[i] = ImageIO.read(new File("src/res/plane/coin/"+i+".png"));
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            image[i] = image[i].getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        }
    }

    @Override
    protected void drawItem(Graphics g) {
        posX -= speed;
        hitBox.x = posX;
        g.drawImage(image[coinRotate], posX, posY, null);
        coinRotate++;
        if(coinRotate == 6) coinRotate = 0;
        if(posX < 0 - 50) reInit();
        if(CheckCollision.checkCollision(this.hitBox)){
            reInit();
            PanelGame.getPlane().setScore();
        }
        //g.setColor(new Color(0, 0, 0));
        //g.drawRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }

    @Override
    protected void reInit(){
        posX = GameFrame.FRAME_WIDTH + 50;
        posY = RndEng.rndEng(30, 500);
        speed = RndEng.rndEng(3, 10);
        hitBox.x = posX;
        hitBox.y = posY;
    }
}




