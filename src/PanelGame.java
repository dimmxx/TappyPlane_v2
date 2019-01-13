import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelGame extends JPanel {

    private int panelWidth = 0;
    private int panelHeight = 0;
    private boolean mousePressed = false;
    private int timerSpeed = 60;

    public PanelGame (int panelWidth, int panelHeight) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mousePressed = true;
            }
        });

        Timer timer = new Timer(timerSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    //private int explosionImageIndex = 0;

    private static Plane plane = new Plane(RndEng.rndEng(30, 500));
    private Ground ground = new Ground();
    private Coin coin1 = new Coin();
    private PuffSmall puffSmall1 = new PuffSmall();
    private PuffLarge puffLarge1 = new PuffLarge();


    public void paintComponent(Graphics g) {

        g.setColor(new Color(77, 86, 255));
        g.fillRect(0, 0, panelWidth, panelHeight);

        if (plane.getHealth() > 0) {

            ground.drawGround(g, panelWidth);

            coin1.drawItem(g);

            plane.drawPlane(g, mousePressed);
            mousePressed = false;

            puffSmall1.drawItem(g);
            puffLarge1.drawItem(g);




//            if (checkCollision(puffLarge1) || checkCollision(puffSmall1) || checkCollision(puffSmall2)) {
//                g.drawImage(plane.getExplosionImage(explosionImageIndex), plane.getPLANE_DISTANCE() - 25, plane.getPlaneHeight() - 35, null);
//                explosionImageIndex++;
//                if (explosionImageIndex == 9) explosionImageIndex = 0;
//            }

            //isCollision = false;

            g.setColor(new Color(0, 255, 255));
            g.drawString("Health: " + plane.getHealth(), 650, 20);
            g.drawString("Score: " + plane.getScore() + "/1000", 650, 40);


        } else {
            g.setColor(new Color(255, 255, 0));
            g.setFont(new Font("Times New Roman", Font.BOLD, 40));
            g.drawString("You lost!!! Game is over.", 200, 310);
        }

        if (plane.getScore() >= 1000 & plane.getHealth() > 0) {
            g.setColor(new Color(77, 86, 255));
            g.fillRect(0, 0, panelWidth, panelHeight);
            g.setColor(new Color(255, 255, 0));
            g.setFont(new Font("Times New Roman", Font.BOLD, 40));
            g.drawString("You won!!! Game is over.", 200, 310);
        }


    }


    public static Plane getPlane() {
        return plane;
    }
}


