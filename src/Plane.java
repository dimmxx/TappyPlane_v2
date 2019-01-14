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

    public Plane(int planeHeight) {
        this.planeHeight = planeHeight;
        planeHitBox = new java.awt.Rectangle(PLANE_DISTANCE, planeHeight, 70, 43);
        try {
            image = ImageIO.read(new File("src/res/plane/plane.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        if (planeHeight > 615) this.setHealth(-100);
        g.setColor(new Color(0, 0, 0));
        g.drawRect(planeHitBox.x, planeHitBox.y, planeHitBox.width, planeHitBox.height);

    }



}
