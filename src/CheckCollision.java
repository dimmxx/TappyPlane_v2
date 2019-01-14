import java.awt.*;

public class CheckCollision {

    public static boolean isCollision = false;
    
    public static boolean checkCollision(Rectangle rectangle){
        if (PanelGame.getPlane().getPlaneHitBox().intersects(rectangle)) {
            //System.out.println("TRUE");
            return true;
        } else {
            return false;
        }
    }
}
