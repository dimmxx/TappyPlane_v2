import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {


    public final static int FRAME_WIDTH = 808;
    public final static int FRAME_HEIGHT = 700;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private int xPos = screenSize.width/2 - FRAME_WIDTH /2;
    private int yPos = screenSize.height/2 - FRAME_HEIGHT /2;

    public GameFrame(){
        super("Tappy Plane v2");
        //setBounds(xPos, yPos, FRAME_WIDTH, FRAME_HEIGHT);
        setBounds(xPos, yPos, FRAME_WIDTH, FRAME_HEIGHT);


        PanelGame panelGame = new PanelGame (FRAME_WIDTH, FRAME_HEIGHT);

        add(panelGame);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(3);
    }








}

