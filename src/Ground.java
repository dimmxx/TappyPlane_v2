import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Ground {

    private int moveGround = 0;
    private Image imageGround = null;

    public Ground() {
        try {
            imageGround = ImageIO.read(new File("src/res/plane/groundGrass.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    protected void drawGround(Graphics g, int panelWidth){
        g.drawImage(imageGround, 0 - moveGround, 608, null);
        g.drawImage(imageGround, 800 - moveGround, 608, null);
        moveGround += 8;
        if (moveGround == panelWidth) moveGround = 0;
    }


}
