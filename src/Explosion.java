import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Explosion {

    private int posX;
    private int posY;
    private int explosionImageIndex = 0;
    private Image[] image = new Image[9];

    public Explosion() {

        for (int i = 0; i < image.length; i++) {
            try {
                image[i] = ImageIO.read(new File("src/res/plane/explosion/" +i+ ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            image[i] = image[i].getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        }
    }

    public void drawItem(Graphics g) {
        if (CheckCollision.isCollision) {
            posX = PanelGame.getPlane().getPlaneHitBox().x;
            posY = PanelGame.getPlane().getPlaneHitBox().y;
            g.drawImage(image[explosionImageIndex], posX, posY, null);
            explosionImageIndex++;
            if(explosionImageIndex == 9) explosionImageIndex = 0;
        }
    }
}
