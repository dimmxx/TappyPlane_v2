import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Plane {

    private int health = 100;
    private int score = 0;
    private int pace = 100;

    private final int PLANE_DISTANCE = 20;
    private int planeHeight;
    private java.awt.Rectangle planeHitBox;
    private Image image = null;

    int explosionEffect = 5;

    public Plane(int planeHeight) {
        this.planeHeight = planeHeight;
        planeHitBox = new java.awt.Rectangle(PLANE_DISTANCE, planeHeight, 70, 43);
        try {
            image = ImageIO.read(new File("src/res/plane/plane.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = image.getScaledInstance(70, 50, Image.SCALE_SMOOTH);


    }


    public int getPLANE_DISTANCE() {
        return PLANE_DISTANCE;
    }

    public int getPlaneHeight() {
        return planeHeight;
    }

    public int getHealth() {
        return health;
    }

    public java.awt.Rectangle getPlaneHitBox() {
        return planeHitBox;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPlaneHeight(int planeHeight) {
        this.planeHeight = planeHeight;
    }

    public void changePlaneHeight(int value) {
        this.planeHeight += value;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        score += pace;
    }

    protected void drawPlane (Graphics g, boolean mousePressed){
        g.drawImage(image, PLANE_DISTANCE, planeHeight, null);
        this.changePlaneHeight(5);
        planeHitBox.y = planeHeight;

        if (mousePressed) {
                if (planeHeight <= 30) {
                    this.setPlaneHeight(30);
                } else this.changePlaneHeight(-30);
            }
        if (planeHeight > 615) {
            CheckCollision.isCollision = true;
            this.setHealth(explosionEffect);
            explosionEffect--;
        }
        //g.setColor(new Color(0, 0, 0));
        //g.drawRect(planeHitBox.x, planeHitBox.y, planeHitBox.width, planeHitBox.height);

    }
}
